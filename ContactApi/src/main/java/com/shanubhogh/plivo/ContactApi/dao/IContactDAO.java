package com.shanubhogh.plivo.ContactApi.dao;

import java.util.List;

import com.shanubhogh.plivo.ContactApi.model.Contact;

public interface IContactDAO {
	
	public Contact getContactDetail(String emailAddress);

	public String saveContactDetail(Contact contactdetail);

	public List<Contact> getContactDetails(String emailAddress, String name);

	public boolean deleteContact(Contact contactdetail);

	public String updatetContact(String contactId, Contact contact);
	
	public List<Contact> getContactDetailsByName(String name);
	
}
