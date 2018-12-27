package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import ua.lviv.lgs.Application;

public class ConnectionUtils {
	private static Logger LOG = Logger.getLogger(Application.class);
	static Connection connection;
	private static String USER_NAME="root";
	private static String USER_PASSWORD="root";
	private static String URL="jdbc:mysql://localhost/magazine?useSSL=false";
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DOMConfigurator.configure("loggerConfig.xml");	
		Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		
		try {
			connection = DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
		} catch (Exception e) {
			LOG.error("no connection to db");
		}
		return connection;
	}

	
}