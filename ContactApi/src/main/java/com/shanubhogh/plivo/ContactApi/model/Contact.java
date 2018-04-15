package com.shanubhogh.plivo.ContactApi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shanubhogh.plivo.ContactApi.model.Address;
import com.shanubhogh.plivo.ContactApi.model.PhoneNumber;

import lombok.*;
@Document
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Setter
	@Getter
	private String id;

	@JsonProperty(value = "emailAddress")
	@Setter
	@Getter
	@NotNull
	@Field("emailAddress")
	private String emailAddress;

	@JsonProperty(value = "firstName")
	@Getter
	@Setter
	@Field
	private String firstName;

	@JsonProperty(value = "lastName")
	@Getter
	@Setter
	@Field
	private String lastName;

	@JsonProperty(value = "middleName")
	@Getter
	@Setter
	@Field
	private String middleName;

///	@JsonProperty(value = "dob")
//	@Getter
//	@Setter
//	@Field
//	private Date DOB;

	@JsonProperty(value = "gender")
	@Getter
	@Setter
	@Field
	private String gender;

	@JsonProperty(value = "phoneNumber")
	@Getter
	@Setter
	@Field
	private PhoneNumber phoneNumber;

	@JsonProperty(value = "address")
	@Getter
	@Setter
	@Field
	private List<Address> address;
	
//	@JsonProperty(value = "_class")
//	@Getter
//	@Setter
//	@Field
//	private String _class;

	@Override
	public String toString() {
		return "Contact [id=" + id + ", emailAddress=" + emailAddress + ", firstName=" + firstName + ",lastName =" +lastName +",middleName =" +middleName 
				+",gender =" + gender +", phoneNumber =" + phoneNumber + ", address= "+address +"  ]";
	}
}
