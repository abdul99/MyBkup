package com.javasampleapproach.customizeauthenticationprovider.security;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        logger.info("Name = " + name + " ,Password = " + password);
        
        // use the credentials and authenticate against the third-party system
        if(("user".equals(name) && "user".equals(password)) 
        		|| ("admin".equals(name) && "admin".equals(password))){
        	logger.info("Succesful authentication!");
        	return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());	
        }
        
        logger.info("Login fail!");
        
        return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
