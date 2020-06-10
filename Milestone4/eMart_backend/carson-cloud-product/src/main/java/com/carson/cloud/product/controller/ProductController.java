package com.carson.cloud.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.carson.cloud.product.entity.ProductEntity;
import com.carson.cloud.product.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * 
	 * @return
	 */
	//ok
	@GetMapping
	public List<ProductEntity> findAllItems(){
		
		return productService.findAllItems();
	}
	
	//ok
	@GetMapping("/getItemById")
	public ResponseEntity<ProductEntity> getItemById(Integer id){
		ProductEntity item = productService.getItemById(id);
		return ResponseEntity.ok(item); 
	}
	
	//ok
	@GetMapping("/getItemByName")
	public ResponseEntity<List<ProductEntity>> getItemByName(String itemName){
		List<ProductEntity> item = productService.getItemByName(itemName);
		return ResponseEntity.ok(item); 
	}
	
//	@PostMapping
//	public ResponseEntity<ProductEntity> addItem(ProductEntity item){
//		productService.addItem(item);
//		return ResponseEntity.status(HttpStatus.CREATED).body(item); 
//	}

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
	
	@GetMapping("/getItemsBySeller/{id}")
	public List<ProductEntity> getItemsBySeller(Integer id){
		
		return productService.getItemsBySeller(id);
	}
}
