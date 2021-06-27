package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.AddressException;
import com.example.demo.model.DaDataException;

public interface DaDataService {

    Address requestToDaData(String source) throws DaDataException, AddressException;

}
