package com.samith.validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.samith.model.Account;
import com.samith.model.Course;
import com.samith.service.AccountService;
import com.samith.service.CourseService;

/**
 * The Class AccountValidator.
 */
public class AccountValidator implements Validator{
	
	/** The log. */
	private static Logger log = Logger.getLogger(AccountValidator.class);
	
	/** The Constant EMAIL_EXISTS. */
	private static final String EMAIL_EXISTS = "email.exists";

	/** The Constant TITLE_EXISTS. */
	private static final String TITLE_EXISTS = "required.course";

	/** The course service. */
	@Autowired
	CourseService courseService;
	
	/** The account service. */
	@Autowired
	AccountService accountService;
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	/**
	 * Supports.
	 *
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Course.class.isAssignableFrom(clazz);

	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	/**
	 * Validate.
	 *
	 * @param target the target
	 * @param errors the errors
	 */
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"required.title", "Title is required.");
		
		Course course = (Course)target;
		if(courseService.isCourseExists(course.getTitle())){
			errors.rejectValue("title", TITLE_EXISTS);
		}
	}
	
	/**
	 * Validate account.
	 *
	 * @param target the target
	 * @param errors the errors
	 */
	public void validateAccount(Object target, Errors errors) {
		log.info("INSIDE validateAccount");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Email is required.");
		
		Account account = (Account)target;
		if(accountService.isAccountExists(account.getEmail())){
			errors.rejectValue("email", EMAIL_EXISTS);
		}
	}
	
}