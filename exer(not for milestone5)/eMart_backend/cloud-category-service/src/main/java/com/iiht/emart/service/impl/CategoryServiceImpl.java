package com.iiht.emart.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.emart.entity.CategoryEntity;
import com.iiht.emart.entity.SubcategoryEntity;
import com.iiht.emart.dao.CategoryDao;
import com.iiht.emart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryEntity> getCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getCategory();
	}

	@Override
	public List<SubcategoryEntity> getSubcategory() {
		// TODO Auto-generated method stub
		return categoryDao.getSubcategory();
	}

	@Override
	public List<SubcategoryEntity> getScByC(String category) {
		// TODO Auto-generated method stub
		return categoryDao.getScByC(category);
	}
	

}
