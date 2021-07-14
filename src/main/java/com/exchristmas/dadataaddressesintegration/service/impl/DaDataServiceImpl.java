package com.exchristmas.dadataaddressesintegration.service.impl;

import com.exchristmas.dadataaddressesintegration.model.*;
import com.exchristmas.dadataaddressesintegration.repos.AddressRepository;
import com.exchristmas.dadataaddressesintegration.service.DaDataService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DaDataServiceImpl implements DaDataService {

    private static final String URL_DADATA_API_CLEAN_ADDRESS = "https://cleaner.dadata.ru/api/v1/clean/address";
    private static final String API_KEY = "ba56f9f54b8af7b8ddec46c4c973516393f78190";
    private static final String SECRET_KEY = "83da60223f10b5f2915609eaf10cfdbc1f458189";

    private final RestTemplate restTemplate;
    private final AddressRepository addressRepository;

    public DaDataServiceImpl(RestTemplate templateBuilder, AddressRepository addressRepository) {
        this.restTemplate = templateBuilder;
        this.addressRepository = addressRepository;
    }

    public Address cleanAddress(String... sourse) throws DaDataException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Token " + API_KEY);
        headers.add("X-Secret", SECRET_KEY);

        HttpEntity<String[]> httpEntity = new HttpEntity<>(sourse, headers);
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

    @Override
    public Address requestToDaData(String source) throws DaDataException{
        if(source.length() > 50)
            throw new DaDataException(DaDataErrorCode.BIG_LENGTH_REQUEST);
        Address addressFromDaData = cleanAddress(source);
        if (addressFromDaData != null) {
            if (!addressRepository.findByFullAddress(addressFromDaData.getFullAddress()).isEmpty())
                return addressFromDaData;
            else
                return addressRepository.insert(addressFromDaData);
        } else {
            throw new DaDataException(DaDataErrorCode.EMPTY_RESPONSE);
        }
    }
}