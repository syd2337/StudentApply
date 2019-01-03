package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AddressMapper;
import com.pojo.Address;
@Service
public class AdressService implements AddressServiceInterface {
	@Resource
	private AddressMapper addressMapper;
	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		addressMapper.addAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		addressMapper.updateAddress(address);
	}

	/* (non-Javadoc)
	 * @see com.service.AddressServiceInterface#selectAddress()
	 */
	@Override
	public Address selectAddress() {
		// TODO Auto-generated method stub
		return addressMapper.selectAddress();
	}

}
