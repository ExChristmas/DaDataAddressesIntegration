package com.exchristmas.dadataaddressesintegration.service;

import com.exchristmas.dadataaddressesintegration.model.Address;
import org.bson.types.ObjectId;

public interface AddressService {

    Address read(ObjectId id);

}