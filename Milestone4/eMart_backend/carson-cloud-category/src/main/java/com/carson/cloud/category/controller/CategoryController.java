package com.carson.cloud.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carson.cloud.category.entity.CategoryEntity;
import com.carson.cloud.category.entity.SubcategoryEntity;
import com.carson.cloud.category.service.CategoryService;


@RestController
@RequestMapping("/category")
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
