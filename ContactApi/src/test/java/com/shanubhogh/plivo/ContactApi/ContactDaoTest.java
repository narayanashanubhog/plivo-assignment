//package com.shanubhogh.plivo.ContactApi;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.couchbase.core.CouchbaseTemplate;
//
//import com.couchbase.client.java.query.N1qlQuery;
//import com.shanubhogh.plivo.ContactApi.dao.ContactDao;
//import com.shanubhogh.plivo.ContactApi.model.Address;
//import com.shanubhogh.plivo.ContactApi.model.Contact;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ContactDaoTest {
//
////	@Mock
////	private CouchbaseTemplate couchbaseTemplate;
////
////	@InjectMocks
////	private ContactDao dao;
////
////	private N1qlQuery queryWithParameter;
////	
////	@Before
////	public void initMock() {
////		initMocks(this);
////		dao = new ContactDao(couchbaseTemplate, queryWithParameter);
////	}
////	
////	@Test
////	public void saveContactDetailTest() {
////		Contact contact = new Contact();
////		dao.saveContactDetail(contact);
////		verify(couchbaseTemplate, times(1)).save(contact);
////	}
////	
////	//@Test
////	//public void UpdateContactDetailTest() {
////	//	Contact contact = new Contact();
////	//	String documentId="narayana_test@gmail.com";
////	//	dao.updatetContact(documentId, contact);
////	//	verify(couchbaseTemplate, times(1)).save(contact);
//////	}
////	
////	//@Test(expected = DataAccessException.class)
////	//public void saveContactExpectionTest() {
////	//	Contact contact = new Contact();
////	//	doThrow(getDataAccessException()).when(couchbaseTemplate).save(contact);
////	//	dao.saveContactDetail(contact);
////	//} 
////	
////	private DataAccessException getDataAccessException() {
////		@SuppressWarnings("serial")
////		DataAccessException ex = new DataAccessException("DataAccessException") {
////		};
////		return ex;
////	}
////	
////	@Test
////	public void removeDocumentByIdTest() {
////		Mockito.doNothing().when(couchbaseTemplate).remove("DD");
////		Contact contact = new Contact();
////		dao.deleteContact(contact);
////	}
////
////	@Test
////	public void removeDocumentExceptionByIdTest() {
////		Contact contact = new Contact();
////		doThrow(getDataAccessException()).when(couchbaseTemplate).remove("DD");
////		dao.deleteContact(contact);
////	}
////	
////	
////	@Test
////	public void getContactDetail() {
////		
////		List<Contact> lstContact=new ArrayList<Contact>();
////		Contact contact=new Contact();
////		contact.setFirstName("Narayana");
////		List<Address> lstAddress=new ArrayList<Address>();
////		Address address=new Address();
////		address.setAddressLine1("Vijayanagar");
////		lstAddress.add(address);
////		contact.setAddress(lstAddress);
////		lstContact.add(contact);
////		
////		String emailAddress="narayan5555@gmai.com";
////		String firstName="Narayana";
////		
////		when(couchbaseTemplate.findByN1QLProjection(Mockito.any(N1qlQuery.class), Mockito.eq(Contact.class)))
////		.thenReturn(lstContact);
////		
////		List<Contact> actualContactList = dao.getContactDetails(emailAddress, firstName);
////		assertEquals(actualContactList.get(0).getFirstName(),lstContact.get(0).getFirstName());
////		//asserEquals(actualContactList.get(0).getAddress().get(0).getAddressLine1().toString(),
////		//		lstContact.get(0).getAddress().get(0).getAddressLine1().toString());
////		
////	}
//	
//}
