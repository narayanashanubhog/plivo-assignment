package com.shanubhogh.plivo.ContactApi.exception;

import lombok.Getter;
import lombok.Setter;

public class ErrorDetail {
	
	@Getter @Setter private String message;
	
	@Getter @Setter private String messageId;
	
	@Getter @Setter private String description;
	
	@Getter @Setter private int statusCode;
	
	@Getter @Setter private Throwable th;
	
	@Override
	public String toString() {
		return "ErrorDetail [message=" + message + ", description="
				+ description + ", th=" + th + "]";
	}
}
