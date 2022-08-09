package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationProvider")
public class AuthenticationProviderImpl  implements AuthenticationProvider{
	

	@Autowired
	private UserDao userDao;
		
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserVO user = userDao.findById(username);
		
		if(user.getPassword().equals(password) == false) {
			throw new BadCredentialsException("비밀번호가 잘못되었습니다");
		}
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(
					username + " 은 회원가입z절차가 완료되지 않음");
		}
		
		UsernamePasswordAuthenticationToken
			token = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		
		return token;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
