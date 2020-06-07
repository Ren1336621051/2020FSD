package com.carson.cloud.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.carson.cloud.order.dao.OrderDao;
import com.carson.cloud.order.entity.OrderEntity;
import com.carson.cloud.order.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	public void addOrder(OrderEntity item) {
		// TODO Auto-generated method stub
		
	}

	public List<OrderEntity> getOrderByBuyerId(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByBuyerId(id);
	}

	public List<OrderEntity> getOrderBySellerId(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderBySellerId(id);
	}

}
