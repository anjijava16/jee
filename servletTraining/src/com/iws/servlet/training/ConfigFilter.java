package com.iws.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class ConfigFilter
 */
@WebFilter(urlPatterns={"/HelloFilterConfigServlet"}, filterName="ConfigFilter", initParams={@WebInitParam(name="construction", value="yes")})
public class ConfigFilter implements Filter {

	FilterConfig fConfig;
	/**
     * Default constructor. 
     */
    public ConfigFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
	    String s = fConfig.getInitParameter("construction");
	    if(s.equals("yes")){  
	         out.print("This page is under construction");  
	    }
	    else{
	         chain.doFilter(request, response);//sends request to next resource
	    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig=fConfig;
	}

}
