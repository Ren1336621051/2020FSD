package com.iiht.emart.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.emart.entity.UserEntity;
import com.iiht.emart.dao.UserDao;
import com.iiht.emart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);

	@Override
	public UserEntity findUserById(Integer id) {
		return userDao.findById(id);
	}
	
	@Override
	public void registUser(UserEntity user){
		
		//create user
		//send mail
		
	}
	
	@Override
	public UserEntity updatePassword(String password,Integer id) {
		userDao.updatePassword(password,id);
		return userDao.findById(id);
	}
}
