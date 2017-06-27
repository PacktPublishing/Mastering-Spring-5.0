package com.mastering.spring.zuul.filters.pre;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SimpleLoggingFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleLoggingFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest httpRequest = context.getRequest();

    log.info(String.format("Request Method : %s \n URL:  %s", httpRequest.getMethod(), httpRequest.getRequestURL().toString()));

    return null;
  }

}