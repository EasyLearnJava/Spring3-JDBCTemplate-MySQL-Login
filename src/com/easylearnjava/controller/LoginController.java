package com.easylearnjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.easylearnjava.model.LoginForm;
import com.easylearnjava.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	//method called from index.jsp page.
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String bindForm(Model model) {
		model.addAttribute("modelObjForm", new LoginForm());
		return "login";
	}
	
	//called when log out button is clicked
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView bindModelView() {
		ModelAndView modelView = new ModelAndView("login");
		modelView.addObject("modelObjForm", new LoginForm());
		return modelView;
	}

	// Hibernate Validator is the reference implementation for JSR 303
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("modelObjForm") LoginForm form, BindingResult result,
			Model model) {

		try {
			
			if (result.hasErrors()) {
				return "login";
			}
			
			boolean isValid = loginService.isValidPassword(form.getUserName(), form.getPassword());

			if (isValid) {
				return "loginSuccess";
			} else {
				result.rejectValue("userName", "login.failed");
				return "login";
			}

		} catch (Exception e) {
			result.rejectValue("userName", "global.exception.message");
			return "login";
		}
	}		

}
