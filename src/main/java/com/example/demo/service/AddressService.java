package com.example.demo.service;

import com.example.demo.model.Address;
import org.bson.types.ObjectId;

public interface AddressService {

    Address read(ObjectId id);

}