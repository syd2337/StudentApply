package com.dao;

import com.pojo.Address;

public interface AddressMapper {
	void addAddress(Address address);
	void updateAddress(Address address);
	Address selectAddress();
}
