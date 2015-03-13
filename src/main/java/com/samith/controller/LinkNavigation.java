package com.samith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samith.model.Account;
import com.samith.model.Course;
import com.samith.service.AccountService;
import com.samith.service.CourseService;

@Controller
public class LinkNavigation {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/sec/moderation", method = RequestMethod.GET)
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}

	@RequestMapping(value = "/admin/first", method = RequestMethod.GET)
	public ModelAndView firstAdminPage() {
		return new ModelAndView("admin-first");
	}

	@RequestMapping(value = "/admin/second", method = RequestMethod.GET)
	public ModelAndView secondAdminPage() {
		return new ModelAndView("admin-second");
	}
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public ModelAndView createAccountPage() {
		ModelAndView model = new ModelAndView("create-account", "command", new Account());
		List<Course> courseList = courseService.findAllCourses();
	    model.addObject("courseList", courseList);
		return model;
	}
	
	@RequestMapping(value = "/createCourse", method = RequestMethod.GET)
	public ModelAndView createCoursePage() {
		
		return new ModelAndView("create-course", "command", new Course());
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Course course, 
	   ModelMap model) {
	      model.addAttribute("title", course.getTitle());
	      courseService.createCourse(course);
	      
	      return "courseResult";
	}
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Account account, 
	   ModelMap model) {
	      model.addAttribute("firstName", account.getFirstName());
	      model.addAttribute("lastName", account.getLastName());
	      model.addAttribute("email", account.getEmail());
	      Course course = courseService.getCourseByName(account.getCourseTitle());
	      account.setCourse(course);
	      accountService.saveAccount(account);
	      
	      return "result";
	}

}
