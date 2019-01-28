package com.ibrahim.springbootjwt.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Auth {
	
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("type")
	private String type;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
