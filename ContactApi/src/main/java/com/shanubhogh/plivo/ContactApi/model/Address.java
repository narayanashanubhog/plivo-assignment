package com.shanubhogh.plivo.ContactApi.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Address {

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "addressLine1")
	private String addressLine1;

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "addressLine2")
	private String addressLine2;

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "city")
	private String city;

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "state")
	private String state;

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "country")
	private String country;

	@Getter
	@Setter
	@Field
//	@JsonProperty(value = "zipcode")
	private String zipcode;

	@Override
	public String toString() {
		return "Contact [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ",state =" + state + ", country=" + country + ", zipcode =" + zipcode + " ]";
	}
}
