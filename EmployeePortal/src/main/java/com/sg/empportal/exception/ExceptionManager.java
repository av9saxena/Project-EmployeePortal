package com.sg.empportal.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sg.empportal.constant.Constants;
import com.sg.empportal.io.RestApiHeader;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler
	public ResponseEntity<RestApiHeader<String>> handleCustomException(EPortalException e) {

		RestApiHeader<String> errorResponse = new RestApiHeader<>();

		errorResponse.setData(null);
		errorResponse.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(e.getErrorCode() + " : " + e.getErrorMessage());
		errorResponse.setStatus(Constants.FAILURE.value());

		ResponseEntity<RestApiHeader<String>> response = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return response;
	}

	@ExceptionHandler
	public ResponseEntity<RestApiHeader<String>> handleGenericError(Exception e) {

		RestApiHeader<String> errorResponse = new RestApiHeader<>();

		errorResponse.setData(null);
		errorResponse.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(ExceptionUtils.getStackTrace(e));
		errorResponse.setStatus(Constants.FAILURE.value());

		ResponseEntity<RestApiHeader<String>> response = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return response;
	}
}
