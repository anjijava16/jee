package com.iws.servlet.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextEventCreateTable
 *
 */
@WebListener
public class ServletContextEventCreateTable implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextEventCreateTable() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");  
	          
	    	String query="insert into emp32 values(1, 'Sree')";
	    	//String query="create table emp32(id number(10),name varchar2(40))";
	    	PreparedStatement ps=con.prepareStatement(query);  
	    	ps.executeUpdate();  
	    	          
	    	System.out.println(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("project undeployed");
    }
	
}
