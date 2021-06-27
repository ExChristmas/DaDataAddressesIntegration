package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressException extends Exception {

    private final AddressErrorCode errorCode;

}