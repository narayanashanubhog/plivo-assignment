package com.shanubhogh.plivo.ContactApi.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shanubhogh.plivo.ContactApi.model.Contact;
import com.shanubhogh.plivo.ContactApi.service.IContactService;

@RestController
@ComponentScan(basePackages = { "com.shanubhogh.plivo.ContactApi" })
public class ContactController {

	@Autowired
	IContactService iContactService;

	@RequestMapping(value = "/GetHealth", method = GET)
	String home() {
		return iContactService.health().toString();
	}

	public ContactController() {
	}

	public ContactController(IContactService service) {
		this.iContactService = service;
	}

	/**
	 * get the health of service
	 * 
	 * @return A String data type.
	 */

	@RequestMapping(value = "/Health", method = GET)
	public String getHealth() throws Exception {
		return iContactService.health().toString();
	}

	/**
	 * save the contact detail.
	 * 
	 * @return A String data type.
	 */
	@RequestMapping(value = "/SaveContact", consumes = "application/json", produces = "application/json", method = POST)
	public String saveContact(@RequestBody Contact contactDetail) throws Exception {
		String result = "";
		try {
			System.out.println(contactDetail.getGender());
			result = iContactService.saveContactDetail(contactDetail);
		} catch (Exception ex) {

		}
		return result;
	}

	/**
	 * Retrieve the contact detail.
	 * 
	 * @return A Contact data type.
	 */
	@RequestMapping(value = "/GetContact", method = GET)
	public ResponseEntity<?> getContact(@RequestParam("emailAddress") String emailAddress) throws Exception {
		Contact contact = null;
		try {
			contact = iContactService.getContactDetail(emailAddress);
		} catch (Exception ex) {

		}
		return ResponseEntity.status(OK).body(contact);
	}

	/**
	 * update the new record.
	 * 
	 * @return string data type.
	 */
	@RequestMapping(value = "/updateContact", method = PUT)
	public String updateContact(@RequestBody Contact contact) throws Exception {
		String result = "";
		try {
			result = iContactService.updateContact(contact);
		} catch (Exception ex) {

		}
		return result;
	}

	/**
	 * delete the contact.
	 * 
	 * @return A String data type.
	 */
	@RequestMapping(value = "/DeleteContact", method = DELETE)
	public boolean deleteContact(@RequestParam("emailAddress") String emailAddress) throws Exception {
		Contact contact = null;
		boolean result = false;
		try {
			contact = iContactService.getContactDetail(emailAddress);
			result = iContactService.deleteContact(contact);
		} catch (Exception ex) {

		}
		return result;
	}

	/**
	 * Retrieve the list of contact detail.
	 * 
	 * @return A String data type.
	 */
	@RequestMapping(value = "/GetContactDetails", method = GET)
	public ResponseEntity<?> getContact(@RequestParam(name="emailAddress", defaultValue = " ") String emailAddress, @RequestParam(name="firstName", defaultValue = " ") String firstName) throws Exception {
		List<Contact> contact = null;
		try {
			contact = iContactService.getContactDetails(emailAddress, firstName);
		} catch (Exception ex) {

		}
		return ResponseEntity.status(OK).body(contact);
	}

}
