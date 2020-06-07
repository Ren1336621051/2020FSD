package com.carson.cloud.category.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carson.cloud.category.dao.CategoryDao;
import com.carson.cloud.category.entity.CategoryEntity;
import com.carson.cloud.category.entity.SubcategoryEntity;
import com.carson.cloud.category.service.CategoryService;


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
