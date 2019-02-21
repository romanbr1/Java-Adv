package ua.lviv.lgs.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.lgs.domain.Univercity;

public interface UnivercityRepository extends JpaRepository<Univercity, Long>, CrudRepository<Univercity, Long>{

	List<Univercity> findByName(String name);
	
	List<Univercity> findByAdress(String adress);
	
	List<Univercity> findByLevel(int level);
		
}
