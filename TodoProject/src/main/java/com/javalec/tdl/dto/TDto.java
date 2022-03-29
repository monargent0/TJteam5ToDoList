package com.javalec.tdl.dto;

import java.sql.Date;

public class TDto {
	
	// Field
	int listCode;
	String todoContent;
	Date dDay;
	String importance;

	// Constructor
	public TDto() {
		// TODO Auto-generated constructor stub
	}

	public TDto(int listCode, String todoContent, Date dDay, String importance) {
		super();
		this.listCode = listCode;
		this.todoContent = todoContent;
		this.dDay = dDay;
		this.importance = importance;
	}

	public int getListCode() {
		return listCode;
	}

	public void setListCode(int listCode) {
		this.listCode = listCode;
	}

	public String getTodoContent() {
		return todoContent;
	}

	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public Date getdDay() {
		return dDay;
	}

	public void setdDay(Date dDay) {
		this.dDay = dDay;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}
	
}
