package com.iiht.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.order.entity.OrderEntity;
import com.iiht.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
//@CrossOrigin(origins="http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 
	 * @return
	 */
//	@GetMapping
//	public List<OrderEntity> findAllItems(){
//		
//		return orderService.findAllItems();
//	}

	@PostMapping
	public ResponseEntity<OrderEntity> addItem(OrderEntity order){
		orderService.addOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order); 
	}

	@GetMapping("/getOrderByBuyerId/{id}")
	public ResponseEntity<List<OrderEntity>> getOrderByBuyerId(@PathVariable Integer id){
		List<OrderEntity> item = orderService.getOrderByBuyerId(id);
		return ResponseEntity.ok(item); 
	}

	@GetMapping("/getOrderBySellerId/{id}")
	public ResponseEntity<List<OrderEntity>> getOrderBySellerId(@PathVariable Integer id){
		List<OrderEntity> item = orderService.getOrderBySellerId(id);
		return ResponseEntity.ok(item); 
	}
}
