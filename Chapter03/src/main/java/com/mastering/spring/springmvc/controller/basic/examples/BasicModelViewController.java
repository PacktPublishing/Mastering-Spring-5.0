package com.mastering.spring.springmvc.controller.basic.examples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicModelViewController {
	@RequestMapping(value = "/welcome-model-view")
	public ModelAndView welcome(ModelMap model) {
		model.put("name", "XYZ");
		return new ModelAndView("welcome-model-view", model);
	}
}
