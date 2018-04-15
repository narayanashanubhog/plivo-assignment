package com.shanubhogh.plivo.ContactApi.dao;

import java.util.ArrayList;
import java.util.List;
import com.shanubhogh.plivo.ContactApi.LoggerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.error.DocumentDoesNotExistException;
import com.couchbase.client.java.query.N1qlQuery;
import com.shanubhogh.plivo.ContactApi.model.Contact;


@Repository
public class ContactDao implements IContactDAO {

	@Autowired
	private CouchbaseTemplate couchbaseTemplate;

	private N1qlQuery queryWithParameter;

	private static final LoggerWrapper logger = new LoggerWrapper(ContactDao.class);

	public ContactDao() {
	}

	public ContactDao(CouchbaseTemplate couchbaseTemplate, N1qlQuery queryWithParameter) {
		this.couchbaseTemplate = couchbaseTemplate;
		this.queryWithParameter = queryWithParameter;

	}

	
	/**
	 * get the single contact detail.
	 * 
	 * @return A Contact data type.
	 */
	@Override
	public Contact getContactDetail(String emailAddress) {
		List<Contact> contact = null;
		try {
			System.out.println(getContact(emailAddress));
			queryWithParameter = N1qlQuery.simple(getContact(emailAddress));
			contact =  couchbaseTemplate.findByN1QLProjection(queryWithParameter,Contact.class);
			
		} catch (Exception ex) {
         System.out.println(ex.getMessage().toString());
		}
		return contact.get(0);
	}

	/**
	 * query to get the single document.
	 * 
	 * @return A String data type.
	 */
	private String getContact(String emailAddress) {
		return "select Contact.* from Contact where emailAddress="+"'"+emailAddress+"'";
	}
	
	
	private String getContactSearch(String emailAddress,String name) {
		return "select Contact.* from Contact where emailAddress="+"'"+emailAddress+"' and firstName="+"'"+name+"'" ;
		//return "select * from Contact WHERE emailAddress='" + emailAddress + "' firstName ='" + name + "'";
	}
	
	private String getContactSearchByName(String name) {
		return "select Contact.* from Contact where firstName="+"'"+name+"'";
	}
	
	/**
	 * insert the new document into couch base.
	 * 
	 * @return A String data type.
	 */
	@Override
	public String saveContactDetail(Contact contactdetail) {

		try {
			couchbaseTemplate.save(contactdetail);
			logger.info(
					"document saved successfully.: " + contactdetail.getFirstName() + contactdetail.getEmailAddress());
		} catch (Exception ex) {
			logger.error("Exception in inserting document: " + ex);
			return "Failed" + ex.getMessage();
		}
		return "Success";

	}

	/**
	 * get the list of contact detail based on emailAddress and name
	 * 
	 * @return A String data type.
	 */
	@Override
	public List<Contact> getContactDetails(String emailAddress, String name) {

		List<Contact> contact = new ArrayList<Contact>();
		try {
			queryWithParameter = N1qlQuery.simple(getContactSearch(emailAddress,name));
			contact =  couchbaseTemplate.findByN1QLProjection(queryWithParameter, Contact.class);
		} catch (Exception ex) {

		}
		return contact;
	}
	
	@Override
	public List<Contact> getContactDetailsByName(String name) {

		List<Contact> contact = new ArrayList<Contact>();
		try {
			queryWithParameter = N1qlQuery.simple(getContactSearchByName(name));
			contact =  couchbaseTemplate.findByN1QLProjection(queryWithParameter, Contact.class);
		} catch (Exception ex) {

		}
		return contact;
	}
	

	/**
	 * delete the record.
	 * 
	 * @return A boolean data type.
	 */
	@Override
	public boolean deleteContact(Contact contactDetail) {
		boolean result = false;
		try {
			couchbaseTemplate.remove(contactDetail);
			result = true;
		} catch (DocumentDoesNotExistException ex) {
			logger.info("Exception occured reason: " + contactDetail + ex);
		} catch (Exception ex) {
			logger.error("Exception in deleteDocumentById: " + ex);
		}
		return result;
	}

	/**
	 * update the existing contact detail. It will delete existing record and save
	 * new record.
	 * 
	 * @return A String data type.
	 */
	@Override
	public String updatetContact(String contactId, Contact contact) {
		try {
			Contact Existingcontact = getContactDetail(contactId);
			deleteContact(Existingcontact);
			saveContactDetail(contact);
		} catch (DataAccessException ex) {
			logger.error("DataAccessException occured reason: ", ex);
			throw ex;
		} catch (Exception e) {
			logger.error("Exception occured reason: ", e);
			return "failled";
		}
		return "update successfully";
	}

}
