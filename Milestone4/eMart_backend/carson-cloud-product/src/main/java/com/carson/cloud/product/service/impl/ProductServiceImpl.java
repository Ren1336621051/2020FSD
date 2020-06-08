package com.carson.cloud.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.carson.cloud.product.dao.ProductDao;
import com.carson.cloud.product.entity.ProductEntity;
import com.carson.cloud.product.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public Page<ProductEntity> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAllItems() {
		// TODO Auto-generated method stub
		return productDao.findAllItems();
	}

	@Override
	public ProductEntity getItemById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.getItemById(id);
	}
	
	@Override
	public List<ProductEntity> getItemByName(String itemName) {
		// TODO Auto-generated method stub
		return productDao.getItemByName(itemName);
	}

//	@Override
//	public void addItem(ProductEntity item) {
//		// TODO Auto-generated method stub
//		productDao.addItem(item);
//	}

	@Override
	public ProductEntity updateQty(Integer qty,Integer id) {
		// TODO Auto-generated method stub
		productDao.updateQty(qty,id);
		return productDao.getItemById(id);
	}

	@Override
	public void deleteItem(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sold(Integer id,Integer qty) {
		Integer sum = productDao.getQty(id) - qty;
		productDao.updateQty(sum,id);
	}

	@Override
	public List<ProductEntity> getItemsBySeller(Integer id) {
		// TODO Auto-generated method stub
		return productDao.getItemsBySeller(id);
	}
	
//	public List<ProductEntity> findAllItems(int page, int pageSize) {
//		// TODO Auto-generated method stub
//		return productDao.findAllItems();
//	}

//	public ProductEntity findUserById(Integer id) {
//		return productDao.findById(id);
//	}
//	
//	public List<ProductEntity> findAllUsers(){
//		return productDao.findAll();
//	}
//	
//	/**
//	 * ����һ��USER��
//	 */
//	public ProductEntity registUser(ProductEntity user){
//		return productDao.saveAndFlush(user);
//	}
//
//	/**
//	 * ����USER��Ϣ��JPA����ID�������޸ģ�
//	 */
//	public ProductEntity update(ProductEntity user) {
//		return productDao.save(user);
//	}
//
//
//	public ProductEntity updateUser(ProductEntity user) {
//		return productDao.save(user);
//	}
//
//	public ProductEntity activeUser(Integer id) {
//		int flag = productDao.activeUser(id);
//		return productDao.findById(id);
//	}
//
//	public void delete(Integer id) {
//		productDao.delete(id);
//	}
}
