package com.sg.empportal.helper;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.sg.empportal.constant.Constants;
import com.sg.empportal.io.RestApiHeader;

@Component
public class ResponseHelper {

	public <T> RestApiHeader<T> getSuccessResponse(T responseObject){
		
		RestApiHeader<T> finalResponse = new RestApiHeader<>();
		
		finalResponse.setData(responseObject);
		finalResponse.setHttpCode(HttpStatus.OK.value());
		finalResponse.setStatus(Constants.SUCCESS.value());
		
		return finalResponse;
	}
}
