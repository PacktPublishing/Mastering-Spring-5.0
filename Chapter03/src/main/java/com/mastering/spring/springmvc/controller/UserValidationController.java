package com.mastering.spring.springmvc.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mastering.spring.springmvc.model.User;

@Controller
public class UserValidationController {

	private Log logger = LogFactory.getLog(UserValidationController.class);

	@RequestMapping(value = "/create-user-with-validation", method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@RequestMapping(value = "/create-user-with-validation", method = RequestMethod.POST)
	public String addTodo(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}

		logger.info("user details " + user);
		return "redirect:list-users";
	}
}