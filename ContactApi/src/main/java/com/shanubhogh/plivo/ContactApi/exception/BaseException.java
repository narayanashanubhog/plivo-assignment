package com.shanubhogh.plivo.ContactApi.exception;


import lombok.Getter;
import lombok.Setter;

public class BaseException extends Exception {
	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private ErrorDetail errorDetail;

	@Getter
	@Setter
	private int statusCode;

	@Override
	public String toString() {
		return "BadDataException [message=" + message + ", errorDetail=" + errorDetail + ", statusCode=" + statusCode
				+ "]";
	}

	public BaseException(String messageId, String Description, int StatusCode) {
		super(Description);
		this.message = Description;
		this.errorDetail = new ErrorDetail();
		errorDetail.setMessage(message);
		errorDetail.setMessageId(messageId);
		errorDetail.setDescription(Description);
		errorDetail.setStatusCode(StatusCode);
		setErrorDetail(errorDetail);
	}
}
