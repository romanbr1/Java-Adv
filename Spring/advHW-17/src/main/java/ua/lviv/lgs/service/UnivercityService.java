package ua.lviv.lgs.service;


import java.util.List;

import ua.lviv.lgs.domain.Univercity;

public interface UnivercityService {

	Univercity save(Univercity univercity);

	Univercity findById(Long id);

	Univercity update(Univercity univercity);

	void deleteById(Long id);

	List<Univercity> findAll();

	List<Univercity> findByName(String name);
	
	List<Univercity> findByAdress(String adress);

	List<Univercity> findByLevel(int level);
}
