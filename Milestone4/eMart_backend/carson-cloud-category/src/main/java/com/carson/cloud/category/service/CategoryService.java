package com.carson.cloud.category.service;

import java.util.List;

import com.carson.cloud.category.entity.CategoryEntity;
import com.carson.cloud.category.entity.SubcategoryEntity;

public interface CategoryService {

	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<CategoryEntity> getCategory();
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<SubcategoryEntity> getSubcategory();
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<SubcategoryEntity> getScByC(String category);
	
}
