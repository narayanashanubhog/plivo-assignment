package com.shanubhogh.plivo.ContactApi.service;

import java.util.List;

import com.shanubhogh.plivo.ContactApi.model.Contact;

public interface IContactService {

	public String health();

	public Contact getContactDetail(String emailAddress);

	public String saveContactDetail(Contact contactdetail);

    public List<Contact> getContactDetails(String emailAddress, String name);

	public boolean deleteContact(Contact ContactDetail);

	public String updateContact(Contact contactDetail);
	
	public List<Contact> getPagination(int startIndex,int EndIndex);

}
