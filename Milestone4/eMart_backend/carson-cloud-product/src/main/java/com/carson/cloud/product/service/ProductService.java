package com.carson.cloud.product.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.carson.cloud.product.entity.ProductEntity;


public interface ProductService {

	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page<ProductEntity> findAll(int page, int pageSize);
	
	/**
	 * select all items
	 * product page
	 * @return
	 */
	public List<ProductEntity> findAllItems();
	
	/**
	 * select item information by ID
	 * product detail page
	 * @param 
	 * @return
	 */
	public ProductEntity getItemById(Integer id);
	
	/**
	 * add product
	 * 
	 * @param item
	 * @return
	 */
//	public void addItem(ProductEntity item);
	
	/**
	 * update product information
	 * 
	 * @param item
	 * @return
	 */
	public ProductEntity updateQty(Integer qty,Integer id);
	
	/**
	 * delete product
	 * 
	 * @param id
	 */
	public void deleteItem(Integer id);
	
	public void sold(Integer id,Integer qty);

	/**
	 * select all items
	 * product page
	 * @return
	 */
	public List<ProductEntity> getItemsBySeller(Integer id);

	public List<ProductEntity> getItemByName(String itemName);
}
