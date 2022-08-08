package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userDetailsService")
public class UserDerailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입을 먼저하세요");
		}
		
		List<AuthorityVO> authoList = userDao.select_auths(username);
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		for(AuthorityVO author : authoList) {
			grantList.add(new SimpleGrantedAuthority(author.getAuthority()));
		}
		
		userVO.setAuthorities(grantList);
		
		return userVO;
	}

}
