package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static String READ_ALL = "select * from users";
	private static String CREATE = "insert into users(`first_name`,`last_name`) values(?,?)";
	private static String READ_BY_ID = "select * from users where user_id=?";
	private static String UPDATE_BY_ID = "update users set first_name=?, last_name=? where user_id=?";
	private static String DELETE_BY_ID = "delete from users where user_id =?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.executeUpdate();
	}

	public User read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeQuery();
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return UserMapper.map(result);

	}

	public void update(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setInt(3, user.getUserId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	List<User> readAll() throws SQLException {
		List<User> listOfEmployee = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfEmployee.add(UserMapper.map(result));
		}
		return listOfEmployee;
	}

}
