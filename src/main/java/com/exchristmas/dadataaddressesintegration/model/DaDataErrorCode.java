package com.exchristmas.dadataaddressesintegration.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum DaDataErrorCode {

    EMPTY_RESPONSE("Empty response from REST service");

    private final String message;

}