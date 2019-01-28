package com.ibrahim.springbootjwt.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Helper {

	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRED = 30000;

	public static String createToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS256, SECRET)
//				.setExpiration(new Date(System.currentTimeMillis() + EXPIRED))
				.compact();
	}
	
	public static String parseToken(String token) {
		String user = "";
		try {
		 user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
		} catch (JwtException e) {
			e.printStackTrace();
		}
		
		
				
		return user;
	
	}
	
	public static String basicAuth(String authorization) {
		String base64Credentials = authorization.substring("Basic".length()).trim();
	    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
	    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
	    String [] data = credentials.split(":");
	    String username = data[0];
	    return username;
	}
	
//	public static void main(String args[]) {
//		String token = Helper.createToken();
//		System.out.println(token);
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UiLCJleHAiOjE1NDg2ODkxODJ9.VrwGceOlC7cjQy6M7qe7eA2TSsaQW4P4mNAbMk5vQb0";
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UiLCJleHAiOjE1NDg2ODkyNDZ9.pPP3etTUPq0nbmgdWt4kD9sJEnDWPtJesp9RIX6Qspk";
		
//		System.out.println(Helper.parseToken(token));
//		System.out.println(Helper.basicAuth("Basic aWJyYWhpbToxMjM0NTY="));
//	}
	

}
