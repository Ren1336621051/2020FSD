package com.carson.cloud.business.controller;

import com.carson.cloud.business.common.Result;
import com.carson.cloud.business.entity.UserEntity;
import com.carson.cloud.business.service.UserService;
import com.carson.cloud.business.viewmodel.LoginByPasswordIVO;
import com.carson.cloud.business.viewmodel.LoginByPasswordOVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
//    @PostMapping(value = "/login/loginByPassword")
//    Result<LoginByPasswordOVO> loginByPassword(@RequestBody LoginByPasswordIVO ivo) {
//        LoginByPasswordOVO ovo = new LoginByPasswordOVO();
//        ovo.setPassword(ivo.getPassword());
//        ovo.setUserName(ivo.getUserName());
//        ovo.setTelephone("180****0000");
//        ovo.setUserId("1001");
//        Result<LoginByPasswordOVO> result = new Result<>();
//        result.setData(ovo);
//        return result;
//    }
	@Autowired
	private UserService userService;
	
	//ok
    @PostMapping(value = "/login/loginByPassword")
    Result<UserEntity> loginByPassword(@RequestBody LoginByPasswordIVO ivo) {
//    	UserEntity user = new UserEntity();
    	UserEntity user = userService.findUserByName(ivo.getUserName());
        String password = user.getPassword();
    	Result<UserEntity> result = new Result<>();
        if(ivo.getPassword().equals(password)) {
            result.setData(user);
        }else {
            result.setData(null);
        	result.setCode(510);
        }
        return result;
    }
}
