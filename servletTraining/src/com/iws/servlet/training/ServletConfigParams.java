package com.iws.servlet.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigParam
 */
@WebServlet(urlPatterns={"/ServletConfigParams"}, initParams={@WebInitParam(name="username", value="sree"), @WebInitParam(name="password", value="password")})
public class ServletConfigParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfigParams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		 PrintWriter out = response.getWriter();  
	      
		 ServletConfig config = getServletConfig();  
		 Enumeration<String> e = config.getInitParameterNames();  
		          
		 String str="";  
		 while(e.hasMoreElements()){  
			 str = e.nextElement();  
			 out.print("<br>Name: "+str);  
			 out.print(" value: "+config.getInitParameter(str));  
		 }  
		          
		 out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
