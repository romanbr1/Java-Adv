package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
	
	
	public static  Magazine map(ResultSet result) throws SQLException {
		int id=result.getInt("id");
		String title = result.getString("title");
		String category = result.getString("category");
		float price=result.getFloat("price");
		return new Magazine(id, title, category, price);
	}
}
