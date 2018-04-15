package com.shanubhogh.plivo.ContactApi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shanubhogh.plivo.ContactApi.dao.IContactDAO;
import com.shanubhogh.plivo.ContactApi.model.Contact;
import com.shanubhogh.plivo.ContactApi.util.ContatcValidation;

@Service
public class ContactService implements IContactService {

	@Autowired
	private IContactDAO iContactDao;

	@Autowired
	ContatcValidation validation;

	@Override
	public String health() {
		return "Hello Shanubhogh";
	}
	
	List<Contact> lstOfContact=new ArrayList<Contact>();

	@Override
	public Contact getContactDetail(String emailAddress) {

		return iContactDao.getContactDetail(emailAddress);
	}

	@Override
	public String saveContactDetail(Contact contactdetail) {
		String response = "";

		if (validation.ValidateEmailAddress(contactdetail.getEmailAddress())
				&& validation.ValidateFirstName(contactdetail.getFirstName())) {
			try {
				String documentName = contactdetail.getFirstName() +"_"+ contactdetail.getEmailAddress();
				contactdetail.setId(documentName);
				response = iContactDao.saveContactDetail(contactdetail);
			} catch (Exception ex) {
				response += ex.getMessage().toString();
			}
		} else {
			response = "Unable to save to contact.Enter the valid entry.";
		}
		return response;

	}

	@Override
	public List<Contact> getContactDetails(String emailAddress, String name) {
		
		if(!lstOfContact.isEmpty()) {
			lstOfContact.clear();
		}
        if(emailAddress !=" " && name != " ") {
        	lstOfContact= iContactDao.getContactDetails(emailAddress, name);
        }
        else if(emailAddress == " " && name != " " )
        {
       	lstOfContact =iContactDao.getContactDetailsByName(name);
        }
        else if(emailAddress != " " && name == " " ) {
        	Contact contact= iContactDao.getContactDetail(emailAddress);
       	lstOfContact.add(contact);
        }
        if(lstOfContact.size()>10) {
        	return lstOfContact.subList(0, 10);
        }
        return lstOfContact;  
	}

	@Override
	public List<Contact> getPagination(int startIndex,int EndIndex)
	{
		if(lstOfContact.size()>EndIndex)
		{
		return lstOfContact.subList(startIndex, EndIndex);
		}
		return lstOfContact.subList(startIndex, lstOfContact.size()-startIndex);
	}
	
	@Override
	public boolean deleteContact(Contact ContactDetail) {

		return iContactDao.deleteContact(ContactDetail);

	}

	/**
	 * Validate valid email and first name and insert a new record.
	 * 
	 * @return A String data type.
	 */

	@Override
	public String updateContact(Contact contactDetail) {
		String response = "";
		if (validation.ValidateEmailAddress(contactDetail.getEmailAddress())
				&& validation.ValidateFirstName(contactDetail.getFirstName())) {
			try {
				String documentName = contactDetail.getFirstName() +"_"+ contactDetail.getEmailAddress();
				contactDetail.setId(documentName);
				response = iContactDao.updatetContact(documentName, contactDetail);
			} catch (Exception ex) {
				response += ex.getMessage().toString();
			}
		} else {
			response = "Unable to save to contact.Enter the valid entry.";
		}
		return response;
	}

}
