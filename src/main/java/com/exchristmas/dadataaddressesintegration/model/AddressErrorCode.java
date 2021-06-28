package com.exchristmas.dadataaddressesintegration.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AddressErrorCode {

    ADDRESS_IS_ALREADY_EXISTS("The address is already exists in database");

    private final String message;

}