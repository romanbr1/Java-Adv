package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
	
	public static  User map(ResultSet result) throws SQLException {
		int user_id=result.getInt("user_id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		String email = result.getString("email");
		String password = result.getString("password");
		return new User(user_id, firstName, lastName, email, password);
	}
	
}
