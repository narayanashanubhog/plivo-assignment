package com.shanubhogh.plivo.ContactApi.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
 

	@Getter @Setter private String firstName;
	
	@Getter @Setter private String lastName;
	
	@Getter @Setter private String middleName;
	

	@Getter @Setter private String gender;
	
    @Getter @Setter private String emailAddress;
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter private PhoneNumber phoneNumber;
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter private List<Address> address;
    
    @Getter @Setter private String _class;
	
}
