package com.shanubhogh.plivo.ContactApi.exception;


import lombok.Getter;
import lombok.Setter;

public class RequestUnauthorizedException {
	@Getter @Setter private ErrorDetail errorDetail;

	public RequestUnauthorizedException() {
		super();
	}

	public RequestUnauthorizedException(ErrorDetail errorDetail) {
		this.errorDetail = errorDetail;
	}

	@Override
	public String toString() {
		return "ApplicationException [errorDetail=" + errorDetail + "]";
	}
}
