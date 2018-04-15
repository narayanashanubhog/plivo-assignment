//package com.shanubhogh.plivo.ContactApi;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.hamcrest.CoreMatchers.*;
//
//import com.shanubhogh.plivo.ContactApi.controller.ContactController;
//import com.shanubhogh.plivo.ContactApi.model.Contact;
//import com.shanubhogh.plivo.ContactApi.service.IContactService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ContactController.class)
//public class ContactControllerTest {
//	
//	
//	   @Autowired
//	    private MockMvc mvc;
//	 
//	    @MockBean
//	    private IContactService service;
//	    
//	//    @Test
//	  //  public void givenContact_whenGetContact_thenReturnJsonArray()
//	    //  throws Exception {
//	         
//	    	  //  Contact contact=new Contact();
//	    	    //contact.setFirstName("Narayana");
//	    	    //List<Contact> allEmployees = Arrays.asList(contact);
////	        when(service.getContactDetails("narayan5555@gmail.com","Nrayana")).thenReturn(allEmployees);
////	        mvc.perform(get("/api/todo/{id}", 1L))
////	                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
////	                        .andExpect(jsonPath("$.id", is(1)))
////	                        .andExpect(jsonPath("$.description", is("Lorem ipsum")))
////	                        .andExpect(jsonPath("$.title", is("Foo")));
////	          verify(service, times(1)).getContactDetails("narayan5555@gmail.com","Nrayana");
////
////	    }
//	    
//}
