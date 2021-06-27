package com.example.demo.config;

import com.example.demo.repos.AddressRepository;
import com.example.demo.service.impl.AddressServiceImpl;
import com.example.demo.service.impl.DaDataServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplateBuilder getRestTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DaDataServiceImpl getDaDataService(AddressRepository addressRepository) {
        return new DaDataServiceImpl(getRestTemplateBuilder(), addressRepository);
    }

    @Bean
    public AddressServiceImpl getAddressService(AddressRepository addressRepository) {
        return new AddressServiceImpl(addressRepository);
    }
}