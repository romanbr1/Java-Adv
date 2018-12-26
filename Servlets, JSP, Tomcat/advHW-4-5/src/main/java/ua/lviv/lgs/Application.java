package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Application {
	private static Logger LOG = Logger.getLogger(Application.class);
	
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		DOMConfigurator.configure("loggerConfig.xml");	
		LOG.info("start application");
		
		MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());
		UserDao userDao = new UserDao(ConnectionUtils.openConnection());
		LOG.info(" successful connection");
		
		// READ ALL
		System.out.println("---- MAGAZINES");
		magazineDao.readAll().stream().forEach(System.out::println);
		System.out.println("---- USERS");
		userDao.readAll().stream().forEach(System.out::println);
		System.out.println("**********************************************************");
//		List<Magazine> listOfMagazine = new ArrayList<>();
//		listOfMagazine.add(new Magazine("Test drive", "Auto"));
//		listOfMagazine.add(new Magazine("Country secrets", "Garden"));
//		listOfMagazine.add(new Magazine("Mens Fitness", "Sport"));
//		listOfMagazine.add(new Magazine("4*4", "Auto"));
//		listOfMagazine.add(new Magazine("Country secrets #2", "Garden"));
//		listOfMagazine.add(new Magazine("Iron world", "Sport"));
		// INSERT Magazines
//		listOfMagazine.forEach(employee->{
//			try {
//				magazineDao.insert(employee);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//		System.out.println("**********************************************************");
		// INSERT Users
//		List<User> listOfUser = new ArrayList<>();
//		listOfUser.add(new User("Mike", "Smith"));
//		listOfUser.forEach(user->{
//			try {
//				userDao.insert(user);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});

//		READ BY ID
		Magazine magazineFromDB = magazineDao.read(2);
		System.out.println(magazineFromDB);

//		UPDATE BY ID 
		magazineFromDB.setTitle(magazineFromDB.getTitle() + "+");
		magazineDao.update(magazineFromDB);
		LOG.info("magazineFromDB updated");
		
//		DELETE BY ID
		magazineDao.delete(6);

//		READ ALL
		magazineDao.readAll().stream().forEach(System.out::println);
		System.out.println("**********************************************************");
		
//		READ BY ID
		UserDB userFromDB = userDao.read(2);
		System.out.println(userFromDB);

//		UPDATE BY ID 
		userFromDB.setFirstName(userFromDB.getFirstName() + "+");
		userDao.update(userFromDB);
		LOG.info("userFromDB updated");
//		DELETE BY ID
		userDao.delete(1);

//		READ ALL
		userDao.readAll().stream().forEach(System.out::println);
		LOG.info("end application");
	}
}
