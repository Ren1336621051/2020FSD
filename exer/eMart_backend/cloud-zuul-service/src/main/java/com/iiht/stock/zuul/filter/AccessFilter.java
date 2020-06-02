package com.iiht.stock.zuul.filter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.security.core.userdetails.User;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.Base64Utils;

/**
 * 资源过滤器
 * 所有的资源请求在路由之前进行前置过滤
 * 如果请求头不包含Authorization参数值，直接拦截不再路由
 * 
 * @author
 *
 */
public class AccessFilter extends ZuulFilter{
//	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
//	
//	@Autowired
//	private RestTemplate restTempate;
	
	/**
	 * 过滤器是否会被执行
	 * 返回true代表需要权限校验，false代表不需要用户校验即可访问
	 */
	@Override
	public boolean shouldFilter() {
        //共享RequestContext，上下文对象
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//
//        System.out.println(request.getRequestURI());
        //不需要权限校验URL
//        if ("/auth/oauth/token".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        } else if ("/apigateway/order/api/v1/order/list".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        } else if ("/apigateway/order/api/v1/order/find".equalsIgnoreCase(request.getRequestURI())) {
//            return false;
//        }
        
        return true;
	}

	/**
	 * 过滤器的类型 pre表示请求在路由之前被过滤
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器的执行顺序
     * @return 顺序 数字越大表示优先级越低，越后执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public Object run() {
		//get user info
		RequestContext ctx = RequestContext.getCurrentContext();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof OAuth2Authentication)) {
			return null;
		}
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication)authentication;
		Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
		//get user shenfen
		String principal = userAuthentication.getName();

		//get user Authentication
		List<String> authorities = new ArrayList<>();
		//get Authentication to userAuthentication from authorities by stream
		userAuthentication.getAuthorities().stream().forEach(c->authorities.add(c.getAuthority()));
//		userAuthentication.getAuthorities().stream().map(authority -> authority.getAuthority()).collect(Collectors.toList());
		OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
		Map<String,String> requestParameters = oAuth2Request.getRequestParameters();
		Map<String, Object> jsonToken = new HashMap<>(requestParameters);
		if(userAuthentication!=null) {
			jsonToken.put("principal", principal);
			jsonToken.put("authorities", authorities);
		}
		
		//shenfen info and authority to http header, transfer to microservice
		try {
			ctx.addZuulRequestHeader("json-token", (Base64.encode(JSON.toJSONString(jsonToken).getBytes("UTF-8"))).toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
