package com.sample.cloud.zuul.common.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessZuulFilter extends ZuulFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		
		RequestContext requestContext = RequestContext.getCurrentContext();
		
		HttpServletRequest httpServletRequest = requestContext.getRequest();
		
		Object accessToken = httpServletRequest.getParameter("accessToken");
		
		
		if (accessToken==null) {
			
			LOGGER.warn("Access token is empty");
			
			requestContext.setSendZuulResponse(false);			
			requestContext.setResponseBody("Access token is empty");
			return null;
		}
		
		LOGGER.info("Access token is right");
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
