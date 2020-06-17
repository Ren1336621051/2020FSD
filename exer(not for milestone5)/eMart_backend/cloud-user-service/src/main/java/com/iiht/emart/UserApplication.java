package com.iiht.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableResourceServer
//@EnableOAuth2Client
public class UserApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(UserApplication.class, args);
	}
}
