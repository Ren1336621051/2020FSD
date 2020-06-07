package com.carson.cloud.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.cloud.business.dao.UserDao;
import com.carson.cloud.business.entity.UserEntity;
import com.carson.cloud.business.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);

	@Override
	public UserEntity findUserByName(String username) {
		return userDao.findByName(username);
	}
	
	@Override
	public void registUser(UserEntity user){
		
		//create user
		//send mail
		
	}
	
	@Override
	public UserEntity updatePassword(String password,String username) {
		userDao.updatePassword(password,username);
		return userDao.findByName(username);
	}

	@Override
	public UserEntity findUserById(String id) {
		return userDao.findById(id);
	}
}
