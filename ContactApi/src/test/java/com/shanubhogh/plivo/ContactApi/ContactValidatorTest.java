package com.shanubhogh.plivo.ContactApi;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shanubhogh.plivo.ContactApi.util.ContatcValidation;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactValidatorTest {

	@Test
	public void validate_right_emailAddress() {
		String rightEmailAddress="narayan5555@gmail.com";
		assertTrue(ContatcValidation.getInstance().ValidateEmailAddress(rightEmailAddress));
	}
	
	@Test
	public void validate_wrong_emailAddress() {
		String rightEmailAddress="gmail.com";
		assertFalse(ContatcValidation.getInstance().ValidateEmailAddress(rightEmailAddress));
	}
	
	@Test
	public void validate_firstName() {
		String firstName="Narayaana";
		assertTrue(ContatcValidation.getInstance().ValidateFirstName(firstName));
	}
	
	@Test
	public void validate__wrong_firstName() {
		String firstName=null;
		assertFalse(ContatcValidation.getInstance().ValidateFirstName(firstName));
	}
	
}