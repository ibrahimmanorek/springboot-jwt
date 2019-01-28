package com.ibrahim.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ibrahim.springbootjwt.pojo.Auth;
import com.ibrahim.springbootjwt.pojo.ForbiddenException;
import com.ibrahim.springbootjwt.utils.Helper;

@RestController
public class IndexController {
	
	@GetMapping("gettoken")
	public Auth getToken(@RequestHeader("Authorization") String authorization) throws ForbiddenException {
		Auth auth = new Auth();
		if(authorization != null) {
			String username = Helper.basicAuth(authorization);
			if(username.equals("ibrahim")) {
				auth.setType("Bearer");
				auth.setToken(Helper.createToken(username));
			}else {
				throw new ForbiddenException("Please check username password");
			}
		}
		return auth;
	}

}
