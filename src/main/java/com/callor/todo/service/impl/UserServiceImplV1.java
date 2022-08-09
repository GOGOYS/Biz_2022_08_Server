package com.callor.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

@Service("userServiceV1")
public class UserServiceImplV1 implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void create_user_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create_auth_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AuthorityVO> select_auths(String username) {
		return userDao.select_auths(username);
	}

	@Override
	public List<UserVO> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		
		List<UserVO> userList = userDao.selectAll();
		List<AuthorityVO> authList = new ArrayList<>();
		
		if(userList == null || userList.size() < 1) {
		
			vo.setEnabled(true);
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_ADMIN")
					.build());
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build());
			
		} else {
			authList.add(AuthorityVO.builder()
					.username(vo.getUsername())
					.authority("ROLE_USER")
					.build());
		}
		
		
		userDao.role_insert(authList);
		return userDao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int role_insert(List<AuthorityVO> auths) {
		// TODO Auto-generated method stub
		return userDao.role_insert(auths);
	}

}
