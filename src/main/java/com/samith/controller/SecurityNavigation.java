package com.samith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class SecurityNavigation.
 */
@Controller
public class SecurityNavigation {

	/**
	 * Login form.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/user-login", method=RequestMethod.GET)  
    public ModelAndView loginForm() {  
        return new ModelAndView("login-form");  
    }  
      
    /**
     * Invalid login.
     *
     * @return the model and view
     */
    @RequestMapping(value="/error-login", method=RequestMethod.GET)  
    public ModelAndView invalidLogin() {  
        ModelAndView modelAndView = new ModelAndView("login-form");  
        modelAndView.addObject("error", true);  
        return modelAndView;  
    }  
      
    /**
     * Success login.
     *
     * @return the model and view
     */
    @RequestMapping(value="/success-login", method=RequestMethod.GET)  
    public ModelAndView successLogin() {  
        return new ModelAndView("success-login");  
    }  
}
