package com.exchristmas.dadataaddressesintegration.controller;

import com.exchristmas.dadataaddressesintegration.model.Address;
import com.exchristmas.dadataaddressesintegration.model.DaDataException;
import com.exchristmas.dadataaddressesintegration.service.DaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DaDataController {

    @NonNull
    private final DaDataService daDataService;

    @Autowired
    public DaDataController(DaDataService daDataService) {
        this.daDataService = daDataService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> create(@RequestBody Map<String, String> query) {
        try {
            Address AddressBeforeInsert = daDataService.requestToDaData(query.get("source"));
            return new ResponseEntity<>(AddressBeforeInsert.getId(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        } catch (DaDataException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}