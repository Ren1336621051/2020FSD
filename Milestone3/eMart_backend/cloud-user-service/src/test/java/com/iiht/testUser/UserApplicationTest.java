package com.iiht.testUser;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

public class UserApplicationTest {
	
    @Autowired
    private WebApplicationContext mac;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUser() throws Exception {
    	String json = "{\"userName\":\"Scofield\",\"password\":\"123456\",\"userType\":\"buyer\",\"email\":\"655432@yahoo.com\",\"mobileNum\":\"12345678901\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/user/regist")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("00000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();


    }
	
}
