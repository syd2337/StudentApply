package com.service;

import com.pojo.Address;

public interface AddressServiceInterface {
	void addAddress(Address address);
	void updateAddress(Address address);
	Address selectAddress();
}
