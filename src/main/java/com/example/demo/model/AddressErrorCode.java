package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AddressErrorCode {

    ADDRESS_IS_ALREADY_EXISTS("The address is already exists in database");

    private final String message;

}