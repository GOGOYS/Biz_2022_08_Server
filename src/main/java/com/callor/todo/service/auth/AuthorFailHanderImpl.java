package com.callor.todo.service.auth;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service("authorFailurHander")
public class AuthorFailHanderImpl extends SimpleUrlAuthenticationFailureHandler{
	
	/*
	 * 인증과정에서 exception 이 발생하면 처리할 이벤트 핸들러
	 */
	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, 
			HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

			String exceptionMessage = "";
			String redirectURL = "/user/login?exception=%s";
			if(exception instanceof BadCredentialsException) {
				exceptionMessage = exception.getMessage();
			} else if(exception instanceof UsernameNotFoundException) {
				exceptionMessage = "로그인을 위하여 회원가입을 해 주세요";
				redirectURL = "/user/join?exception=%s";
			}
		
			exceptionMessage = URLEncoder.encode(exceptionMessage,"UTF-8");
			redirectURL = String.format(redirectURL, exceptionMessage);

			setDefaultFailureUrl(redirectURL);
		
			super.onAuthenticationFailure(request, response, exception);
	}
}
