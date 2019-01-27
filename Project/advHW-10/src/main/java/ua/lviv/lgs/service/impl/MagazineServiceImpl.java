package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.dao.impl.MagazineDaoImpl;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.service.MagazineService;

public class MagazineServiceImpl implements MagazineService {
	private static Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
	private static MagazineService magazineServiceImpl;
	private MagazineDao magazineDao;

	private MagazineServiceImpl() {
		try {
			magazineDao = new MagazineDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static  MagazineService getMagazineService() {
		if (magazineServiceImpl == null) {
			magazineServiceImpl = new MagazineServiceImpl();
		}

		return magazineServiceImpl;
	}




	@Override
	public Magazine create(Magazine t) {
		return magazineDao.create(t);
	}

	@Override
	public Magazine read(Integer id) {
		return magazineDao.read(id);
	}

	@Override
	public Magazine update(Magazine t) {
		return magazineDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		magazineDao.delete(id);
	}

	@Override
	public List<Magazine> readAll() {
		return magazineDao.readAll();
	}
	@Override
	public Map<Integer, Magazine> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
	}
	
}
