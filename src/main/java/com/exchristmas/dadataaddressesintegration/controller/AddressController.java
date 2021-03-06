package com.exchristmas.dadataaddressesintegration.controller;

import com.exchristmas.dadataaddressesintegration.model.Address;
import com.exchristmas.dadataaddressesintegration.service.AddressService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @NonNull private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> read(@PathVariable(name = "id") ObjectId id) {
        final Address address = addressService.read(id);

        return address != null
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}