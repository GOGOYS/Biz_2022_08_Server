package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	
	private final TodoService todoService;
	public TodoController(TodoService todoService) {
		// TODO Auto-generated constructor stub
		this.todoService = todoService;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String todo(Model model) {
		
		List<TodoVO> todoList = todoService.selectAll();
		model.addAttribute("TODOLIST",todoList);
		return null;
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String insert() {
		
		return null;
	}
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String insert(TodoVO todoVO, Principal principal) {
		todoVO.setUsername(principal.getName());

		todoService.insert(todoVO);
		return "redirect:/todo/list";
	}
	
	
	@RequestMapping(value="/{seq}/update",method=RequestMethod.GET)
	public String update(@PathVariable("seq")String seq, Model model) {
		
		long longSeq = Long.valueOf(seq);
		TodoVO todoVO = todoService.findById(longSeq);
		if(todoVO.getD_date() == null) {
			return "redirect:/todo/list";
		}
		
		model.addAttribute("TODO", todoVO);
		return "todo/input";
	}
	
	@RequestMapping(value="/{seq}/update",method=RequestMethod.POST)
	public String update(TodoVO todoVO, Model model) {
		todoService.update(todoVO);
		return "redirect:/todo/list";
	}
	
	@RequestMapping(value="/{seq}/finish",method=RequestMethod.GET)
	public String finish(TodoVO todoVO,String seq,Model model) {
		
		
		Date curDate = new Date(System.currentTimeMillis());	
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		String today = dateFormat.format(curDate);
		String time = timeFormat.format(curDate);
		todoVO.setF_date(today);
		todoVO.setF_time(time);
		todoVO.setFinish(true);
		todoService.update(todoVO);
		
		
		return "redirect:/todo/list";
	}	

}
