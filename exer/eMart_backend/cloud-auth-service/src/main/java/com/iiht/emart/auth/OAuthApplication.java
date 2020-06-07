package com.iiht.emart.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
//@RestController                    //34p
//@EnableResourceServer
//@EnableAuthorizationServer
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
@EnableFeignClients(basePackages = {"com.iiht.emart.auth"})
public class OAuthApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
	}
}
