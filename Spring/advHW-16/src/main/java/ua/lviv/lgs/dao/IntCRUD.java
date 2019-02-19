package ua.lviv.lgs.dao;


public interface IntCRUD<T> {

	void create(String name, int age);

	void read(int id);
	
	void update(int id, String name, int age);
	
	void delete(int id);

	void readAll();
	
	

	

	

	
}
