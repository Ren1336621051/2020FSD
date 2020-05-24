package com.iiht.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.iiht.order.dao.OrderDao;
import com.iiht.order.entity.OrderEntity;
import com.iiht.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Override
	public void addOrder(OrderEntity item) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<OrderEntity> getOrderByBuyerId(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByBuyerId(id);
	}

	@Override
	public List<OrderEntity> getOrderBySellerId(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderBySellerId(id);
	}


}
