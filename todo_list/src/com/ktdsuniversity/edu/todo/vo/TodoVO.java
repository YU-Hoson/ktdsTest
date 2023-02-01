package com.ktdsuniversity.edu.todo.vo;

public class TodoVO {
	
	private String itemName;
	private boolean isSuccess;
	
	public TodoVO(String itemName) {
		setItemName(itemName);
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
}
