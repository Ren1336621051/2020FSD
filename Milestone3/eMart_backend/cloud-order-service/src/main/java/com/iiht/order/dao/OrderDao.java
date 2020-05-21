package com.iiht.order.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iiht.order.entity.OrderEntity;


@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer>{
	
	public static final EntityManager entityManager = null;
	
	Date  date =new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
	String date1 = sdf.format(date);

	@Transactional
	@Query(value = "select * from s_order o where o.buyer_id=?",nativeQuery = true)
	public List<OrderEntity> getOrderByBuyerId(@Param("id")Integer id);
	
	@Transactional
	@Query(value = "select * from s_order o where o.seller_id=?",nativeQuery = true)
	public List<OrderEntity> getOrderBySellerId(@Param("id")Integer id);
	

	@Transactional
	@Query(value = "insert into s_order (id,buyer_id,seller_id,item_id,qty,transaction_type,crtDate)"
			+ "values(#{id},#{buyer_id},#{seller_id},#{item_id},#{qty},#{transaction_type},#{crtDate})",nativeQuery = true)
	public void addOrder(OrderEntity order);
}
