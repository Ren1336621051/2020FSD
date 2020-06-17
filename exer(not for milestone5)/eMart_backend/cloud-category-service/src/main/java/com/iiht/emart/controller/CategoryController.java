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

import com.iiht.emart.entity.CategoryEntity;
import com.iiht.emart.entity.SubcategoryEntity;
import com.iiht.emart.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/getCategory")
	public ResponseEntity<List<CategoryEntity>> getCategory(){
		List<CategoryEntity> ce = service.getCategory();
		return ResponseEntity.ok(ce);
	}
	@GetMapping("/getSubcategory")
	public ResponseEntity<List<SubcategoryEntity>> getSubcategory(){
		List<SubcategoryEntity> ce = service.getSubcategory();
		return ResponseEntity.ok(ce);
	}
	@GetMapping("/getScByC")
	public ResponseEntity<List<SubcategoryEntity>> getScByC(String category){
		List<SubcategoryEntity> ce = service.getScByC(category);
		return ResponseEntity.ok(ce);
	}
	
}
