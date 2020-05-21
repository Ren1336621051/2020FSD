package com.iiht.emart.controller;

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

import com.iiht.emart.entity.ProductEntity;
import com.iiht.emart.service.ProductService;

@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<ProductEntity> findAllItems(){
		
		return productService.findAllItems();
	}
	
	@GetMapping("/getItemById/{id}")
	public ResponseEntity<ProductEntity> getItemById(@PathVariable Integer id){
		ProductEntity item = productService.getItemById(id);
		return ResponseEntity.ok(item); 
	}
	
	@PostMapping
	public ResponseEntity<ProductEntity> addItem(ProductEntity item){
		productService.addItem(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(item); 
	}

	@PutMapping
	public ResponseEntity<ProductEntity> updateQty(Integer qty,Integer id){
		ProductEntity ProductEntity = productService.updateQty(qty,id);
		return ResponseEntity.ok(ProductEntity); 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id){
		productService.deleteItem(id);
		return ResponseEntity.ok("Delete Item successfully.");
	}
	
	@GetMapping
	public List<ProductEntity> getItemsBySeller(Integer id){
		
		return productService.getItemsBySeller(id);
	}
}
