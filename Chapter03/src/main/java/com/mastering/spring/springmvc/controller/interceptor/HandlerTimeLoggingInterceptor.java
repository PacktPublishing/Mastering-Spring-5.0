package com.mastering.spring.springmvc.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HandlerTimeLoggingInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger
			.getLogger(HandlerTimeLoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("endTime", System.currentTimeMillis());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = (Long) request.getAttribute("endTime");
		logger.info("Time Spent in Handler in ms : " + (endTime - startTime));
	}

}