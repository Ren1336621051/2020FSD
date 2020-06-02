package com.iiht.emart.auth.service;

import com.iiht.emart.auth.entity.UserEntity;

public interface UserService {

	/**
	 * 
	 * @param 
	 * @return
	 */
	public UserEntity findUserById(Integer id);
	
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
	public UserEntity updatePassword(String password,Integer id);
	
}
