package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;



import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.FactoryManager;


public class MagazineDaoImpl implements MagazineDao {

	private EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	@Override
	public Magazine create(Magazine magazine) {
		try {
			em.getTransaction().begin();
			em.persist(magazine);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		LOGGER.error("sss");
		return magazine;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			

		} catch (Exception e) {
			LOGGER.error(e);
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {

		try {
			
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return magazine;
	}

	@Override
	public void delete(Integer id) {
		try {
			
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Magazine> readAll() {
		Query query =null;
		try {
			query=em.createQuery("SELECT e FROM magazine e");
		} catch (Exception e) {
			LOGGER.error(e);
		}
System.out.println("--"+query);
		return (List<Magazine>) query.getResultList();
	}

}
