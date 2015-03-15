package com.samith.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samith.exception.E3LearningException;
import com.samith.model.Account;
import com.samith.model.Course;
import com.samith.model.Training;
import com.samith.service.AccountService;
import com.samith.service.CourseService;
import com.samith.service.TrainingService;
import com.samith.validator.AccountValidator;

/**
 * The Class LinkNavigation.
 */
@Controller
public class LinkNavigation {
	
	/** The account service. */
	@Autowired
	AccountService accountService;
	
	/** The course service. */
	@Autowired
	CourseService courseService;
	
	/** The training service. */
	@Autowired
	TrainingService trainingService;
	
	/** The account validator. */
	AccountValidator accountValidator;
	
	/** The log. */
	private static Logger log = Logger.getLogger(LinkNavigation.class);
	
	/**
	 * Instantiates a new link navigation.
	 *
	 * @param customeValidator the custome validator
	 */
	@Autowired
	public LinkNavigation(AccountValidator customeValidator){
		this.accountValidator = customeValidator;
	}
	
	/**
	 * Home page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}

	/**
	 * Index page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}

	/**
	 * Moderator page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/sec/moderation", method = RequestMethod.GET)
	public ModelAndView moderatorPage() {
		return new ModelAndView("moderation");
	}

	/**
	 * First admin page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/admin/first", method = RequestMethod.GET)
	public ModelAndView firstAdminPage() {
		return new ModelAndView("admin-first");
	}

	/**
	 * Second admin page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/admin/second", method = RequestMethod.GET)
	public ModelAndView secondAdminPage() {
		return new ModelAndView("admin-second");
	}
	
	/**
	 * Creates the account page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public ModelAndView createAccountPage() {
		ModelAndView model = new ModelAndView("create-account", "account", new Account());
		List<Course> courseList = courseService.findAllCourses();
	    model.addObject("courseList", courseList);
		return model;
	}
	
	/**
	 * Creates the course page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/createCourse", method = RequestMethod.GET)
	public ModelAndView createCoursePage() {
		
		return new ModelAndView("create-course", "course", new Course());
	}
	
	/**
	 * Adds the course.
	 *
	 * @param course the course
	 * @param model the model
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	@ExceptionHandler({E3LearningException.class})
	public ModelAndView addCourse(@ModelAttribute("course") Course course, 
	   ModelMap model, BindingResult result) {
		accountValidator.validate(course, result);
	    model.addAttribute("title", course.getTitle());
	      if (result.hasErrors()) {
				//if validator failed
			return new ModelAndView("create-course");
			} else {
				courseService.createCourse(course);
			}
	      return new ModelAndView("courseResult", "command", course);
	}
	
	/**
	 * Instantiates a new link navigation.
	 */
	public LinkNavigation() {
		super();
	}

	/**
	 * Adds the student.
	 *
	 * @param account the account
	 * @param model the model
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("account") Account account, 
	   ModelMap model, BindingResult result) {
		log.info("INSIDE addStudent ");
		accountValidator.validateAccount(account, result);
		if (result.hasErrors()) {
			log.info("Returned with validation errors");
			//if validator failed
			ModelAndView modelAndView = new ModelAndView("create-account","account", account);
			List<Course> courseList = courseService.findAllCourses();
			modelAndView.addObject("courseList", courseList);
			return modelAndView;
		} else {
			model.addAttribute("firstName", account.getFirstName());
		    model.addAttribute("lastName", account.getLastName());
		    model.addAttribute("email", account.getEmail());
		    Course course = courseService.getCourseByName(account.getCourseTitle());
		    account.setCourse(course);
		    accountService.createAccount(account);
		}
			return new ModelAndView("result", "account", account);
	}
	
	/**
	 * Search account page.
	 *
	 * @param account the account
	 * @return the model and view
	 */
	@RequestMapping(value = "/searchAccount", method = RequestMethod.GET)
	public ModelAndView searchAccountPage(@ModelAttribute Account account) {
		ModelAndView model = new ModelAndView("search-account", "command", new Account());
		return model;
	}
	
	/**
	 * Search account details page.
	 *
	 * @param account the account
	 * @return the model and view
	 */
	@RequestMapping(value = "/searchAccount", method = RequestMethod.POST)
	public ModelAndView searchAccountDetailsPage(@ModelAttribute Account account) {
		ModelAndView model = new ModelAndView("search-account", "command", new Account());
		List<Account> listAccounts = accountService.getAccountsByName(account.getFirstName(), account.getLastName());
		model.addObject("listAccounts", listAccounts);
		return model;
	}
	
	
	/**
	 * Adds the edit training page.
	 *
	 * @param accountId the account id
	 * @param courseId the course id
	 * @return the model and view
	 */
	@RequestMapping(value = "/edit/{accountId}/{courseId}", method = RequestMethod.GET)
	public ModelAndView addEditTrainingPage(@PathVariable Integer accountId, @PathVariable Integer courseId) {
		Training training = trainingService.getTrainingPerCourse(accountId, courseId);
		if(training != null){
			log.info("addEditTrainingPage "+training.getAccountId());
			log.info("addEditTrainingPage "+training.getCourseId());
		}
		ModelAndView model = new ModelAndView("add-edit-training", "command", training == null ? new Training(accountId, courseId) : training);
		return model;
	}
	
	/**
	 * Adds the training.
	 *
	 * @param training the training
	 * @return the model and view
	 */
	@RequestMapping(value = "/addTraining", method = RequestMethod.POST)
	public ModelAndView addTraining(@ModelAttribute Training training) {
		log.info("Account ID "+training.getAccountId());
		log.info("Account ID "+training.getCourseId());
		trainingService.saveTraining(training);
		ModelAndView model = new ModelAndView("add-edit-training", "command", training);
		return model;
	}
	
}
