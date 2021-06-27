package com.example.demo.service.impl;

import com.example.demo.model.Address;
import com.example.demo.repos.AddressRepository;
import com.example.demo.service.AddressService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address read(ObjectId id) {
        return addressRepository.findById(id).orElse(null);
    }
}