package com.exchristmas.dadataaddressesintegration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DaDataException extends Exception {

    private final DaDataErrorCode errorCode;

}