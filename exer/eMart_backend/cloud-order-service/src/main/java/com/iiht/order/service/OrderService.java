package com.iiht.order.service;

import java.util.List;

import com.iiht.order.entity.OrderEntity;


public interface OrderService {

	/**
	 * add order
	 * 
	 * @param item
	 * @return
	 */
	public void addOrder(OrderEntity item);
	
	/**
	 * select order information by buyer id
	 * 
	 * @param 
	 * @return
	 */
	public List<OrderEntity> getOrderByBuyerId(Integer id);
	
	/**
	 * select order information by seller id
	 * 
	 * @param 
	 * @return
	 */
	public List<OrderEntity> getOrderBySellerId(Integer id);
	
	
}
