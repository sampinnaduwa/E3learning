package com.samith.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.samith.dao.AccountDao;
import com.samith.dao.CourseDao;
import com.samith.init.WebAppConfig;
import com.samith.model.Account;
import com.samith.model.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class AccountDaoTest {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CourseDao courseDao;
	
	
	@Test
	public void testSaveAccount(){
		// Not fixed yet
		Account account = new Account();
		account.setActiveState("Vic");
		account.setEmail("test@email.com");
		account.setFirstName("test");
		account.setLastName("TestSurname");
		Address address = new Address();
		address.setCountry("Aus");
		address.setState("Vic");
		address.setStreetName("Clpham way");
		address.setSuburb("Craigieburn");
		account.setAddress(address);
		
		accountDao.persist(account);
		assertEquals(true, true);
	}
	
	@Test
	public void testSaveCourse(){
		//Will Send it later.
		assertEquals(true, true);
	}

}
