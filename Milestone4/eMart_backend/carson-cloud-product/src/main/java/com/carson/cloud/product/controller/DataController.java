package com.carson.cloud.product.controller;

import com.carson.cloud.product.common.Result;
import com.carson.cloud.product.entity.ProductEntity;
import com.carson.cloud.product.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
//    @GetMapping(value = "/data/getData")
//    Result<GetDataOVO> getData(@RequestHeader("userId") String UserId) {
//        GetDataOVO ovo = new GetDataOVO();
//        ovo.setList(CollectionUtils.arrayToList(new String[]{"张*三", "李*四", "王*五", "马*六"}));
//        Result<GetDataOVO> result = new Result<>();
//        result.setData(ovo);
//        return result;
//    }

	@Autowired
	private ProductService productService;

	//ok
	@GetMapping(value = "/products")
	Result<List<ProductEntity>> getAllData() {
	List<ProductEntity> list = productService.findAllItems();
	Result<List<ProductEntity>> result = new Result<>();
    result.setData(list);
    return result;
	}
}
