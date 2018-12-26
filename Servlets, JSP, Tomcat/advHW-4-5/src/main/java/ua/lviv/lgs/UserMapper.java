package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
	
	public static  UserDB map(ResultSet result) throws SQLException {
		int userId=result.getInt("user_id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
		return new UserDB(userId, firstName, lastName);
	}
	
}
