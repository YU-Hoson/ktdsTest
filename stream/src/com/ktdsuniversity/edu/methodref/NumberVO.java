package com.ktdsuniversity.edu.methodref;

public class NumberVO {

	private int number;

	public NumberVO(int number) {
		this.number = number;
	}
	
	public boolean isEven() {
		return this.number % 2 == 0;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
