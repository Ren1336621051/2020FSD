package com.carson.cloud.address.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.cloud.address.dao.AddressDao;
import com.carson.cloud.address.entity.AddressEntity;
import com.carson.cloud.address.service.AddressService;


@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao addressDao;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);

	@Override
	public List<AddressEntity> findByUser(Integer id) {
		return addressDao.findByUser(id);
	}
	
	@Override
	public void add(AddressEntity user){
		
	}
	
	@Override
	public AddressEntity updateAddress(String address,Integer id) {
		addressDao.updateAddress(address,id);
		return addressDao.findById(id.toString());
	}

	@Override
	public AddressEntity deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
