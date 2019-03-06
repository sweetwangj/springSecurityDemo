package com.operation.qkwall.security;

import java.util.Collection;

import com.operation.qkwall.entity.Admin;
import com.operation.qkwall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author 自定义验证
 *
 */
@Component
public class YcAnthencationProder implements AuthenticationProvider {
	@Autowired
	private UserService userService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		    String username = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        Admin admin =userService.getUserByname(username);
	        if(admin == null){
                logger.info("Username not found.");
	            throw new BadCredentialsException("Username not found.");
	        }

	        //加密过程在这里体现
				BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
            if (!passwordEncoder.matches(password,admin.getPassword())) {
                logger.info("Wrong password");
	            throw new BadCredentialsException("Wrong password.");
	        }

	        Collection<? extends GrantedAuthority> authorities = userService.loadUserByUsername(username).getAuthorities();
	        return new UsernamePasswordAuthenticationToken(admin, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
