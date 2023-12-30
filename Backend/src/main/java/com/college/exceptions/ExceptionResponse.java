package com.college.exceptions;

import java.util.Date;

public class ExceptionResponse {
	
	private String details;
	private Date date;
	private String message;
	private Integer serverStatus;
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExceptionResponse(String details, Date date, String message, Integer serverStatus) {
		super();
		this.details = details;
		this.date = date;
		this.message = message;
		this.serverStatus = serverStatus;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Integer getServerStatus() {
		return serverStatus;
	}


	public void setServerStatus(Integer serverStatus) {
		this.serverStatus = serverStatus;
	}
	

}
