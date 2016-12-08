package com.iws.servlet.training;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextEventDBCon
 *
 */
@WebListener
public class ServletContextEventDBCon implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextEventDBCon() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	try{  
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
    		          
    		//storing connection object as an attribute in ServletContext  
    		ServletContext ctx = event.getServletContext();  
    		ctx.setAttribute("mycon", con);  
    		          
    		}catch(Exception e){e.printStackTrace();}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
