package com.iiht.emart.service;

import java.util.List;

import com.iiht.emart.entity.CategoryEntity;
import com.iiht.emart.entity.SubcategoryEntity;

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
