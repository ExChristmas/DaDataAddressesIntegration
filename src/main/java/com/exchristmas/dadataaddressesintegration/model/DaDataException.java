package com.exchristmas.dadataaddressesintegration.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DaDataException extends Exception {

    private final DaDataErrorCode errorCode;

}