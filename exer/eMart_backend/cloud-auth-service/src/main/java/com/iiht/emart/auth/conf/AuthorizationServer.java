package com.iiht.emart.auth.conf;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private ClientDetailsService clientDetailsService;
	
//	@Autowired
//	private AuthorizationCodeServices authorizationCodeServices;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("zuul")
//                .secret("secret")
                .secret(new BCryptPasswordEncoder().encode("secret"))
                .resourceIds("res1")
                .scopes("all").autoApprove(true)
//                .authorities("WRIGTH_READ", "WRIGTH_WRITE")
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
    }
    public AuthorizationServerTokenServices tokenService() { 
    	DefaultTokenServices service = new DefaultTokenServices();
    	service.setClientDetailsService(clientDetailsService);
    	service.setSupportRefreshToken(true);
    	service.setTokenStore(tokenStore);
    	
    	TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
    	tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
    	service.setTokenEnhancer(tokenEnhancerChain);
    	
    	service.setAccessTokenValiditySeconds(7200);
    	service.setRefreshTokenValiditySeconds(259200);
    	return service;
    }
    
//    public AuthorizationCodeServices authorizationCodeServices() {
//    	return new InMemoryAuthorizationCodeServices();
//    }
//    
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .authenticationManager(authenticationManager)
//                .authorizationCodeServices(authorizationCodeServices)
//                .tokenServices(tokenService())
//                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    	security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }
    
}
