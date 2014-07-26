package com.easylearnjava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easylearnjava.model.LoginForm;
import com.easylearnjava.service.LoginService;

@Controller
@RequestMapping(value={"/loginpage", "/login"})
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String bindForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	// Hibernate Validator is the reference implementation for JSR 303
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Model model) {

		try {
			if (result.hasErrors()) {
				return "login";
			}

			boolean isValid = loginService.isValidPassword(loginForm.getUserName(), loginForm.getPassword());

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
