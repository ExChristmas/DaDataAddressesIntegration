package com.exchristmas.dadataaddressesintegration.service.impl;

import com.exchristmas.dadataaddressesintegration.model.Address;
import com.exchristmas.dadataaddressesintegration.repos.AddressRepository;
import com.exchristmas.dadataaddressesintegration.service.AddressService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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