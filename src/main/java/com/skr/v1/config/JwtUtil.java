package com.skr.v1.config;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	static @ResponseBody JwtResponse addAuthentication(HttpServletResponse res, String username)
	{
		JwtResponse jwtResponse= new JwtResponse();
		String token=Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, "Forerunner")
				.compact();
		res.addHeader("Authorization", token);
		jwtResponse.setToken(token);
		return jwtResponse;
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		
		String token=request.getHeader("Authorization");
		
		if(token!=null)
		{
			String User=Jwts.parser()
					.setSigningKey("Forerunner")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			
			return User!=null?
					new UsernamePasswordAuthenticationToken(User, null, emptyList()):
						null;
		}
		return null;
	}

	private static Collection<? extends GrantedAuthority> emptyList() {
		// TODO Auto-generated method stub
		return null;
	}
}
