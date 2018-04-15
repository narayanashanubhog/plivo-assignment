package com.shanubhogh.plivo.ContactApi.bean;
import lombok.*;

public class PhoneNumber {

	@Getter
	@Setter
	private int primaryNumber;
	
	@Getter
	@Setter
	private int secondaryNumber;
	
	@Getter
	@Setter
	private int landLine;

	@Override
	public String toString() {
		return "Contact [primaryNumber=" + primaryNumber +  "secondaryNumber=" + secondaryNumber
				+ ", landLine=" + landLine + "]";
	}
}
