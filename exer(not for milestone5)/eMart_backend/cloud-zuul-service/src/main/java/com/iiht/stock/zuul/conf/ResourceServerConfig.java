package com.iiht.stock.zuul.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class ResourceServerConfig {

	public static final String RESOURCE_ID = "emart";

	@Configuration
	@EnableResourceServer
	public class AuthServerConfig extends ResourceServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		public void configure(ResourceServerSecurityConfigurer resources) {
			resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
		}

		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/cloud-auth-service/**").permitAll();
		}
	}

//	@Configuration
//	@EnableResourceServer
//	public class UserServerConfig extends ResourceServerConfigurerAdapter {
//
//		@Autowired
//		private TokenStore tokenStore;
//
//		public void configure(ResourceServerSecurityConfigurer resources) {
//			resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
//		}
//
//		public void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().antMatchers("/cloud-user-service/**").access("#oauth2.hasScope('ROLE_ADMIN')");
//		}
//
//	}
}
