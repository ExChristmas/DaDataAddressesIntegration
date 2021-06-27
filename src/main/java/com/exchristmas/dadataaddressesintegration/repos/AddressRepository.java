package com.example.demo.repos;

import com.example.demo.model.Address;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {

    @Query("{ 'fullAddress' : ?0 }")
    List<Address> findByFullAddress(String fullAddress);

}