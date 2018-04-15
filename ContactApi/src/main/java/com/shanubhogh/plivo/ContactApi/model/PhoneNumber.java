package com.shanubhogh.plivo.ContactApi.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class PhoneNumber {

	@Getter
	@Setter
	@Field
	@JsonProperty(value = "primaryNumber")
	private int primaryNumber;

	@Getter
	@Setter
	@Field
	@JsonProperty(value = "secondaryNumber")
	private int secondaryNumber;

	@Getter
	@Setter
	@Field
	@JsonProperty(value = "landLine")
	private int landLine;

}
