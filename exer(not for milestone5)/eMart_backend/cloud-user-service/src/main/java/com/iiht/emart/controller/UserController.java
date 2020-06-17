package com.iiht.emart.controller;

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

import com.iiht.emart.entity.UserEntity;
import com.iiht.emart.service.UserService;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/findUserById/{id}")
	public UserEntity findUserById(@PathVariable Integer id){
		
		return userService.findUserById(id);
	}
	
	//password encode
	@PostMapping("/regist")
	public ResponseEntity<UserEntity> regist(UserEntity user){
		userService.registUser(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<UserEntity> updatePassword(String password,Integer id){
		UserEntity userEntity = userService.updatePassword(password,id);
		return ResponseEntity.ok(userEntity); 
	}
	
}
