package com.sg.empportal.constant;

public enum Constants {

	SUCCESS("Success"),
	FAILURE("FAILURE");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
