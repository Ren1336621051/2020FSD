package com.iiht.emart.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.emart.entity.AddressEntity;
import com.iiht.emart.dao.AddressDao;
import com.iiht.emart.dao.UserDao;
import com.iiht.emart.service.AddressService;

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
		return addressDao.findById(id);
	}

	@Override
	public AddressEntity deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
