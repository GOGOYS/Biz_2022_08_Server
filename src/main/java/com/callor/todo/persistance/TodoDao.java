package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoDao{
	
	public List<TodoVO> selectAll();
	public TodoVO findById(long seq);
	public int insert(TodoVO todoVO);
	public int update(TodoVO todoVO);
	public int delete(long seq);
}
