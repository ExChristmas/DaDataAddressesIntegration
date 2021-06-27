package com.example.demo.service.impl;

import com.example.demo.config.HeaderRequestInterceptor;
import com.example.demo.model.*;
import com.example.demo.repos.AddressRepository;
import com.example.demo.service.DaDataService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class DaDataServiceImpl implements DaDataService {

    private static final String URL_DADATA_API_CLEAN_ADDRESS = "https://cleaner.dadata.ru/api/v1/clean/address";
    private static final String API_KEY = "ba56f9f54b8af7b8ddec46c4c973516393f78190";
    private static final String SECRET_KEY = "83da60223f10b5f2915609eaf10cfdbc1f458189";

    @NonNull
    private final RestTemplateBuilder restTemplateBuilder;
    @NonNull
    private final RestTemplate restTemplate;
    @NonNull
    private final AddressRepository addressRepository;

    public DaDataServiceImpl(RestTemplateBuilder restTemplateBuilder, AddressRepository addressRepository) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = createRestTemplate();
        this.addressRepository = addressRepository;
    }

    public Address cleanAddress(String... sourse) throws DaDataException {
        HttpEntity<String[]> httpEntity = new HttpEntity<>(sourse);
        ResponseEntity<Address[]> response = restTemplate.exchange(
                URL_DADATA_API_CLEAN_ADDRESS,
                HttpMethod.POST,
                httpEntity,
                Address[].class);
        Address[] result = response.getBody();
        if (result != null) {
            if (result.length > 0)
                return result[0];
        }
        throw new DaDataException(DaDataErrorCode.EMPTY_RESPONSE);

    }

    @NonNull
    private RestTemplate createRestTemplate() {
        List<ClientHttpRequestInterceptor> interceptors = Arrays.asList(
                new HeaderRequestInterceptor(HttpHeaders.AUTHORIZATION, "Token " + API_KEY),
                new HeaderRequestInterceptor("X-Secret", SECRET_KEY));
        Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();
        mapperBuilder.featuresToEnable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE,
                DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        MappingJackson2HttpMessageConverter jsonMessageConverter =
                new MappingJackson2HttpMessageConverter(mapperBuilder.build());
        return restTemplateBuilder.detectRequestFactory(true)
                .interceptors(interceptors)
                .messageConverters(jsonMessageConverter)
                .build();
    }

    @Override
    public Address requestToDaData(String source) throws DaDataException, AddressException {
        Address addressFromDaData = cleanAddress(source);
        if (addressFromDaData != null) {
            if (!addressRepository.findByFullAddress(addressFromDaData.getFullAddress()).isEmpty())
                throw new AddressException(AddressErrorCode.ADDRESS_IS_ALREADY_EXISTS);
            else
                return addressRepository.insert(addressFromDaData);
        } else {
            throw new DaDataException(DaDataErrorCode.EMPTY_RESPONSE);
        }
    }
}