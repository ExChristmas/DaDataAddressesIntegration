package com.exchristmas.dadataaddressesintegration.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddressException extends Exception {

    private final AddressErrorCode errorCode;

}