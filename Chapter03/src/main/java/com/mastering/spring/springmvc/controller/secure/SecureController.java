package com.mastering.spring.springmvc.controller.secure;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecureController {

	@RequestMapping(value = "/secure/welcome")
	public String welcome(ModelMap map) {
		map.put("name", getLoggedInUserName());
		return "secure-welcome-page";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

}
