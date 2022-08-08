package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TodoVO {
	
	public long seq;
	public String username;
	public String todo;
	public String d_time;
	public String d_date;
	public String f_time;
	public String f_date;
	public boolean finish;
}
