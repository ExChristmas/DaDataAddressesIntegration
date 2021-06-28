package com.exchristmas.dadataaddressesintegration.service;

import com.exchristmas.dadataaddressesintegration.model.Address;
import com.exchristmas.dadataaddressesintegration.model.AddressException;
import com.exchristmas.dadataaddressesintegration.model.DaDataException;

public interface DaDataService {

    Address requestToDaData(String source) throws DaDataException, AddressException;

}
