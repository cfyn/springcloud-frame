package com.siwei.frame.user.provider.filter;//package com.siwei.frame.user.provider.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Component;
//
//import BodyReaderHttpServletRequestWrapper;
//
//@Component
//@WebFilter(filterName = "MainFilter", urlPatterns = "/*")
//public class MainFilter implements Filter {
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//		ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
//		
//		chain.doFilter(requestWrapper, response);
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}
//
//}
