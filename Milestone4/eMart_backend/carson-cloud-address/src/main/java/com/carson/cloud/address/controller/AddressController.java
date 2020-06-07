package com.carson.cloud.address.controller;

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

import com.carson.cloud.address.entity.AddressEntity;
import com.carson.cloud.address.service.AddressService;


@RestController
@RequestMapping("/user/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/findByUser")
	public ResponseEntity<List<AddressEntity>> findByUser(Integer id){
		addressService.findByUser(id);
		return ResponseEntity.ok(addressService.findByUser(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<AddressEntity> add(AddressEntity address){
		addressService.add(address);
		return  ResponseEntity.status(HttpStatus.CREATED).body(address);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AddressEntity> update(String address,Integer id){
		AddressEntity addressEntity = addressService.updateAddress(address,id);
		return ResponseEntity.ok(addressEntity); 
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<AddressEntity> delete(Integer id){
		AddressEntity addressEntity = addressService.deleteAddress(id);
		return ResponseEntity.ok(addressEntity); 
	}
	
}
