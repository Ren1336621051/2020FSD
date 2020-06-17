package com.iiht.emart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableResourceServer
//@EnableOAuth2Client
//@EnableEurekaClient
public class AddressApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(AddressApplication.class, args);
	}
}
