package ua.lviv.lgs;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class Application {
	private static Logger LOG = Logger.getLogger(Application.class);
	
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		DOMConfigurator.configure("loggerConfig.xml");	
		LOG.info("start application");
		
		UserService userService = new UserServiceImpl();
		userService.create(new User("test@test","test","test","test", "test"));
		
		
		LOG.info("end application");
	}
}
