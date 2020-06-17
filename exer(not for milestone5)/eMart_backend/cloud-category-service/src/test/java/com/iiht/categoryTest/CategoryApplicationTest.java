package com.iiht.categoryTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.emart.controller.CategoryController;
import com.iiht.emart.entity.CategoryEntity;
import com.iiht.emart.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CategoryController.class,secure = false)
public class CategoryApplicationTest {
    private static Logger logger = LoggerFactory.getLogger(CategoryApplicationTest.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService CategoryService;

    @Test
    public void getCategory() throws Exception{
        CategoryEntity category = new CategoryEntity();
        category.setId(1);
        category.setCategory_name("Electrical");
        category.setDesc("machines power by electricity.");

        List<CategoryEntity> categorys = new ArrayList<>();
        categorys.add(category);

        Mockito.when(CategoryService.getCategory()).thenReturn(categorys);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/category/getCategory");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	String expected = "{\"id\":1,\"CategoryName\":\"Electrical\",\"setDesc\":\"machines power by electricity.\"}";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

}
