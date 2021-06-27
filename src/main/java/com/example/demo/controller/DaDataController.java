package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.model.AddressException;
import com.example.demo.model.DaDataException;
import com.example.demo.service.DaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaDataController {

    @NonNull private final DaDataService daDataService;

    @Autowired
    public DaDataController(DaDataService daDataService) {
        this.daDataService = daDataService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody String source) {
        try {
            Address AddressBeforeInsert = daDataService.requestToDaData(source);
            return new ResponseEntity<>(AddressBeforeInsert.getId(),
                    new HttpHeaders(),
                    HttpStatus.CREATED);
    } catch (DaDataException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } catch (AddressException ex) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }
}