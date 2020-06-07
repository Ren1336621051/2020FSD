package com.carson.cloud.address.service;

import java.util.List;

import com.carson.cloud.address.entity.AddressEntity;


public interface AddressService {

	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<AddressEntity> findByUser(Integer id);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public void add(AddressEntity user);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public AddressEntity updateAddress(String address,Integer id);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public AddressEntity deleteAddress(Integer id);
	
}
