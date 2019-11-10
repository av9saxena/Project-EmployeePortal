package com.sg.empportal.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "httpCode", "data", "message"})
public class RestApiHeader<T> {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("httpCode")
	private Integer httpCode;
	
	@JsonProperty("data")
	private T data;
	
	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("httpCode")
	public Integer getHttpCode() {
		return httpCode;
	}

	@JsonProperty("httpCode")
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	@JsonProperty("data")
	public T getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(T data) {
		this.data = data;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
}
