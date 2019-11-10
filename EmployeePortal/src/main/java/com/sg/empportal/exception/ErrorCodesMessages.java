package com.sg.empportal.exception;

public enum ErrorCodesMessages {

	EP_0001("Please make sure to provide Firstname, Lastname, Gender, Date Of Birth, Department");
	
	private String errorMessage;
	
	private ErrorCodesMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
