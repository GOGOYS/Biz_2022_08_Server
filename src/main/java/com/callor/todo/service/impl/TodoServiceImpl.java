package com.callor.todo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	
	
	private final TodoDao todoDao;
	public TodoServiceImpl(TodoDao todoDao) {
		
		this.todoDao = todoDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(long id) {
		// TODO Auto-generated method stub
		
		return todoDao.findById(id);
	}

	@Override
	public int insert(TodoVO vo) {
		// TODO Auto-generated method stub
		
		Date curDate = new Date(System.currentTimeMillis());	
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		String today = dateFormat.format(curDate);
		String time = timeFormat.format(curDate);
		
		vo.setD_date(today);
		vo.setD_time(time);
		
		
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		
		if(vo.getF_date() == null) {
			
			Date curDate = new Date(System.currentTimeMillis());	
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
			
			String today = dateFormat.format(curDate);
			String time = timeFormat.format(curDate);
			
			vo.setD_date(today);
			vo.setD_time(time);
		}
		
		return todoDao.update(vo);
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
