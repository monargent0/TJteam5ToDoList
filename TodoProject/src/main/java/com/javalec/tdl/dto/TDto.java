package com.javalec.tdl.dto;

import java.sql.Date;

public class TDto {

	int listCode;
	String todoContent;
	String importance;
	Date dDay;
	
	public TDto() {
		// TODO Auto-generated constructor stub
	}

	public TDto(int listCode, String todoContent, String importance, Date dDay) {
		super();
		this.listCode = listCode;
		this.todoContent = todoContent;
		this.importance = importance;
		this.dDay = dDay;
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

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public Date getdDay() {
		return dDay;
	}

	public void setdDay(Date dDay) {
		this.dDay = dDay;
	}
}
