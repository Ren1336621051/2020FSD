package com.iiht.emart.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.emart.entity.ProductEntity;


@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer>{
	
	public static final EntityManager entityManager = null;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);
	
	@Transactional
	@Query(value = "select * from s_product",nativeQuery = true)
	public List<ProductEntity> findAllItems();

	@Transactional
	@Query(value = "select * from s_product p where p.id=?",nativeQuery = true)
	public ProductEntity getItemById(Integer id);

	@Transactional
	@Query(value = "insert into s_order (id,buyer_id,seller_id,item_id,qty,transaction_type,crtDate)"
			+ "values(#{id},#{buyer_id},#{seller_id},#{item_id},#{qty},#{transaction_type},#{crtDate})",nativeQuery = true)
	public void addItem(ProductEntity item);

	@Transactional
	@Query(value = "delete from s_product p where p.id=?",nativeQuery = true)
	public void deleteItem(@Param("id")Integer id);

	@Transactional
	@Query(value = "select p.qty from s_product p where p.id=?",nativeQuery = true)
	public int getQty(@Param("id")Integer id);
	
	@Modifying
	@Transactional
	@Query(value = "update s_product p set p.qty=? where p.id=?",nativeQuery = true)
	public int updateQty(@Param("qty")Integer qty,@Param("id")Integer id);
	

	@Transactional
	@Query(value = "select * from s_product p where p.id=?",nativeQuery = true)
	public List<ProductEntity> getItemsBySeller(@Param("id")Integer id);
}
