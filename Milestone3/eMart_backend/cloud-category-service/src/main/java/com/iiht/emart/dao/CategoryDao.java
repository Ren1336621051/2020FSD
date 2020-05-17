package com.iiht.emart.dao;

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

import com.iiht.emart.entity.CategoryEntity;
import com.iiht.emart.entity.SubcategoryEntity;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>{

	@Transactional
	@Query(value = "select * form s_category",nativeQuery = true)
	public List<CategoryEntity> getCategory();
	
	@Transactional
	@Query(value = "select * form s_subcategory",nativeQuery = true)
	public List<SubcategoryEntity> getSubcategory();

	@Transactional
	@Query(value = "select s_subcategory a where a.category=?",nativeQuery = true)
	public List<SubcategoryEntity> getScByC(String category);
	
	@Modifying
	@Transactional
	@Query(value = "update s_address a set a.address=? where u.id=?",nativeQuery = true)
	public void updateAddress(@Param("address")String address,@Param("id")Integer id);

	@Transactional
	@Query(value = "delete from s_address where u.id=?",nativeQuery = true)
	public void deleteAddress(@Param("id")Integer id);
	
}
