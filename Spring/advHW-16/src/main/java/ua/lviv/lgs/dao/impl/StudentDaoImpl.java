package ua.lviv.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import advHW16.advHW16.Student;
import ua.lviv.lgs.dao.IntCRUD;

public class StudentDaoImpl implements IntCRUD<Student> {

	List<Student> students = new ArrayList<>();

	@Override
	public void create(String name, int age) {
		int id = students.size() + 1;
		Student student = new Student(id, name, age);
		students.add(student);
	}

	@Override
	public void read(int id) {
		System.out.println("student #" + id + " - " + students.get(id - 1));
	}

	@Override
	public void readAll() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
		System.out.println("----size= " + students.size());
	}

	@Override
	public void update(int id, String name, int age) {
		students.set(id - 1, new Student(id, name, age));
	}

	@Override
	public void delete(int id) {
		students.remove(id-1);

	}

}