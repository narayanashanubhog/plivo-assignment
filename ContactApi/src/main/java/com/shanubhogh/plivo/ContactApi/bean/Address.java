package com.shanubhogh.plivo.ContactApi.bean;

import lombok.*;
public class Address {

	@Getter
	@Setter
	private String addressLine1;
	
	@Getter
	@Setter
	private String addressLine2;
	
	@Getter
	@Setter
	private String city;
	
	@Getter
	@Setter
	private String state;
	
	@Getter
	@Setter
	private String country;
	
	@Getter
	@Setter
	private String zipcode;

	
}
