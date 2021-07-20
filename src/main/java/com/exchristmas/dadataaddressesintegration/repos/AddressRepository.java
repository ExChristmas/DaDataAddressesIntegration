package com.exchristmas.dadataaddressesintegration.repos;

import com.exchristmas.dadataaddressesintegration.model.Address;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {

    Address findByFullAddress(String fullAddress);

}