package com.wzx.bookstore.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

	static Logger log = Logger.getLogger(EncodingFilter.class);
	private String encoding = "";
    /**
     * Default constructor. 
     */
    public EncodingFilter() {

    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	  	log.info("destory");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

      	encoding = fConfig.getInitParameter("encoding");
      	log.info("init"+encoding);
	}

}
