package com.shanubhogh.plivo.ContactApi.exception;


import lombok.Getter;
import lombok.Setter;

public class DocumentAlreadyExistException extends Exception {
@Getter @Setter private String message;
	
	@Getter @Setter private ErrorDetail errorDetail;
	
	@Getter @Setter private int statusCode;

	public DocumentAlreadyExistException() {
		super();
	}

	public DocumentAlreadyExistException(String message,Throwable cause) {
		super(message);
		this.message = message;
		this.errorDetail = new ErrorDetail();
		errorDetail.setMessage(message);
		errorDetail.setMessageId("Document already exist");
		errorDetail.setDescription("Try with different combination");
		errorDetail.setTh(cause);
		errorDetail.setStatusCode(409);
		setErrorDetail(errorDetail);
	}

	
	@Override
	public String toString() {
		return "NoTripAssignedException [message=" + message + ", errorDetail="
				+ errorDetail + ", statusCode=" + statusCode + "]";
	}
}
