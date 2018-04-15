package com.shanubhogh.plivo.ContactApi;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.*;

import com.shanubhogh.plivo.ContactApi.controller.ContactController;
import com.shanubhogh.plivo.ContactApi.model.Address;
import com.shanubhogh.plivo.ContactApi.model.Contact;
import com.shanubhogh.plivo.ContactApi.model.PhoneNumber;
import com.shanubhogh.plivo.ContactApi.service.IContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerTest {
	
	
	   @Autowired
	    private MockMvc mvc;
	 
	    @MockBean
	    private IContactService service;
	    
	    @Test
	    public void givenEmail_whenGetContact_thenReturnJsonArray()
	      throws Exception {
	        Contact contact=new Contact();
	    	    contact.setFirstName("Narayana");
	    	    contact.setLastName("Shanubhogh");
	    	    contact.setEmailAddress("narayan5555@gmail.com");
	    	    
	    	    List<Contact> allEmployees = Arrays.asList(contact);
	        when(service.getContactDetail("narayan5555@gmail.com")).thenReturn(allEmployees.get(0));
	        mvc.perform(get("/GetContact?emailAddress=narayan5555@gmail.com"))
	                        .andExpect(jsonPath("$.lastName", is("Shanubhogh")));
	          verify(service, times(1)).getContactDetail("narayan5555@gmail.com");
	    }
	 
	    private List<Contact> getListOfAllContact(){
	    	
	    	List<Contact> lstContact=new ArrayList<Contact>();
	    	for(int i=0;i<12;i++) {
	    	Contact c1= new Contact();
	    	c1.setFirstName("Test");
	    	c1.setLastName("DEmo");
	    	c1.setEmailAddress("demo@outlok.com"+i);
	    	c1.setGender("male");
	    	c1.setMiddleName("N");
	    	List<Address> lstAddress=new ArrayList<Address>();
        Address address=new Address();
        address.setAddressLine1("vijayanagar");
        address.setAddressLine2("bangalore");
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setState("Karnatka");
        address.setZipcode("576223");
        lstAddress.add(address);
	    c1.setAddress(lstAddress);
	    PhoneNumber p=new PhoneNumber();
	    p.setPrimaryNumber(1234);
	    p.setSecondaryNumber(34343);
	    p.setLandLine(13124);
	    c1.setPhoneNumber(p);
	    lstContact.add(c1);
	    	}
	    	return lstContact;
	    	
	    }
}
