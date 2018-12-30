package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.impl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;

public class MagazineServiceImpl implements MagazineService {
	private static Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
	private static MagazineService magazineServiceImpl;
	private MagazineDao productDao;

	private MagazineServiceImpl() {
		try {
			productDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static MagazineService getProductService() {
		if (magazineServiceImpl == null) {
			magazineServiceImpl = new MagazineServiceImpl();
		}

		return magazineServiceImpl;
	}

	@Override
	public Magazine create(Magazine t) {
		return productDao.create(t);
	}

	@Override
	public Magazine read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Magazine update(Magazine t) {
		return productDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Magazine> readAll() {
		return productDao.readAll();
	}

}
