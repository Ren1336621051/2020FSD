package com.iiht.testUser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.emart.controller.UserController;
import com.iiht.emart.entity.UserEntity;
import com.iiht.emart.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class,secure = false)
public class UserApplicationTest {
    private static Logger logger = LoggerFactory.getLogger(UserApplicationTest.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void findUserById() throws Exception{
        UserEntity user = new UserEntity();
        user.setId(1001);
    	user.setUserName("scofield");
    	user.setPassword("123456");
    	user.setEmail("renzhidl@scofield.com");
    	user.setMobileNum("12345678901");
    	user.setUserType("buyer");

        List<UserEntity> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userService.findUserById(1001)).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/findUserById/1001");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	String expected = "{\"id\":1001,\"userName\":\"Scofield\",\"password\":\"123456\",\"userType\":\"buyer\",\"email\":\"renzhidl@scofield.com\",\"mobileNum\":\"12345678901\"}";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
    
    @Test
    public void addUserRole() throws Exception{
    	String JSON = "{\"id\":1002,\"userName\":\"JackJones\",\"password\":\"654321\",\"userType\":\"seller\",\"email\":\"jackjones@yahoo.com\",\"mobileNum\":\"029-48328\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/regist")
                .accept(MediaType.APPLICATION_JSON).content(JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(),response.getStatus());
        String expected = "{\"id\":1002,\"userName\":\"JackJones\",\"password\":\"654321\",\"userType\":\"seller\",\"email\":\"jackjones@yahoo.com\",\"mobileNum\":\"029-48328\"}";
        logger.info(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

}
