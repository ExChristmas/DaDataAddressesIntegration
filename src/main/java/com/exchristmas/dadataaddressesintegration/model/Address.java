package com.exchristmas.dadataaddressesintegration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "address")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @Id
    private String id;

    @Field("fullAddress")
    @JsonProperty("result")
    private String fullAddress;

    @Field("regionKladrId")
    @JsonProperty("region_kladr_id")
    private String regionKladrId;

    @Field("region")
    @JsonProperty("region_with_type")
    private String region;

    @Field("city")
    private String city;

    @Field("streetKladrId")
    @JsonProperty("street_kladr_id")
    private String streetKladrId;

    @Field("street")
    @JsonProperty("street_with_type")
    private String street;

    @Field()
    @JsonProperty("house_type")
    private String houseType;
    private String house;

    @JsonProperty("kladr_id")
    private String kladrId;

    @JsonProperty("flat_type")
    private String flatType;
    private String flat;

    private Address() {
    }
}