package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
	private static String READ_ALL = "select * from magazines";
	private static String CREATE = "insert into magazines(`title`,`category`) values(?,?)";
	private static String READ_BY_ID = "select * from magazines where id=?";
	private static String UPDATE_BY_ID = "update magazines set title=?, category=? where id=?";
	private static String DELETE_BY_ID = "delete from magazines where id =?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MagazineDao(Connection connection) {
		this.connection = connection;
	}

	public void insert(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getTitle());
		preparedStatement.setString(2, magazine.getCategory());
		preparedStatement.executeUpdate();
	}

	public Magazine read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeQuery();
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return MagazineMapper.map(result);

	}

	public void update(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getTitle());
		preparedStatement.setString(2, magazine.getCategory());
		preparedStatement.setInt(3, magazine.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	List<Magazine> readAll() throws SQLException {
		List<Magazine> listOfMagazine = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMagazine.add(MagazineMapper.map(result));
		}
		return listOfMagazine;
	}

}
