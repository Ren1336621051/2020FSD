package com.carson.cloud.business.service;

import com.carson.cloud.business.entity.UserEntity;

public interface UserService {

	/**
	 * 
	 * @param 
	 * @return
	 */
	public UserEntity findUserByName(String username);

	public UserEntity findUserById(String id);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public void registUser(UserEntity user);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity updatePassword(String password,String username);
	
}
