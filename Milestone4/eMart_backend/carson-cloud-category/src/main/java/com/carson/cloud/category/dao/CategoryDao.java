package com.carson.cloud.category.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carson.cloud.category.entity.CategoryEntity;
import com.carson.cloud.category.entity.SubcategoryEntity;


@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>{

	@Transactional
	@Query(value = "select * form s_category",nativeQuery = true)
	public List<CategoryEntity> getCategory();
	
	@Transactional
	@Query(value = "select * form s_subcategory",nativeQuery = true)
	public List<SubcategoryEntity> getSubcategory();

	@Transactional
	@Query(value = "select s_subcategory s where s.category=?",nativeQuery = true)
	public List<SubcategoryEntity> getScByC(String category);

}
