package com.javalec.tdl.dto;


public class TDto {

	String userId;
	int listCode;
	String todoContent;
	String importance;
	String dDay;
	String todoStatus;
	
	public TDto() {
		// TODO Auto-generated constructor stub
	}

	public TDto(String userId, int listCode, String todoContent, String importance, String dDay, String todoStatus) {
		super();
		this.userId = userId;
		this.listCode = listCode;
		this.todoContent = todoContent;
		this.importance = importance;
		this.dDay = dDay;
		this.todoStatus = todoStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getdDay() {
		return dDay;
	}

	public void setdDay(String dDay) {
		this.dDay = dDay;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}
	
}
