package com.iiht.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
//@EnableEurekaClient
public class CategoryApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(CategoryApplication.class, args);
	}
}
