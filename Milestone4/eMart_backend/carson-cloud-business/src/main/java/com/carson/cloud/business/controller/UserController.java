package com.carson.cloud.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carson.cloud.business.entity.UserEntity;
import com.carson.cloud.business.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @return
	 */
//	@GetMapping("/findUserById/{id}")
//	public UserEntity findUserById(@PathVariable Integer id){
//		
//		return userService.findUserById(id);
//	}
	
	//password encode
	@PostMapping("/regist")
	public ResponseEntity<UserEntity> regist(UserEntity user){
		userService.registUser(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<UserEntity> updatePassword(String password,String username){
		UserEntity userEntity = userService.updatePassword(password,username);
		return ResponseEntity.ok(userEntity); 
	}
	
}
