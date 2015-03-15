package com.samith.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.samith.init.WebAppConfig;
import com.samith.model.Account;
import com.samith.model.Address;
import com.samith.model.Course;
import com.samith.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration
public class E3LearningTest {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CourseService courseService;
	
	@Test
	public void testSaveAccount(){
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
	public void testGetCourseByName(){
		Course course = courseService.getCourseByName("Spring");
		assertEquals(course.getTitle(), "Spring");
	}
	
	@Test
	public void testGetCourseById(){
		Course course = courseService.getCourse(1);
		assertEquals(course.getId(), 1);
	}
	
	

}
