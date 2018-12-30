package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao {

	private static String READ_ALL = "select * from magazines";
	private static String CREATE = "insert into magazines(`title`,`category`) values(?,?)";
	private static String READ_BY_ID = "select * from magazines where id=?";
	private static String UPDATE_BY_ID = "update magazines set title=?, category=? where id=?";
	private static String DELETE_BY_ID = "delete from magazines where id =?";

	private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MagazineDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Magazine create(Magazine product) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			product.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer magazineId = result.getInt("id");
			String title = result.getString("name");
			String category = result.getString("description");
			Float price = result.getFloat("price");
			magazine = new Magazine(magazineId, title, category, price);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine product) {

		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> magazineRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("id");
				String title = result.getString("name");
				String category = result.getString("description");
				Float purchasePrice = result.getFloat("price");

				magazineRecords.add(new Magazine(id, title, category, purchasePrice));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return magazineRecords;
	}

}
