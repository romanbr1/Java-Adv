package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Univercity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private int level;
	
	@Column
	private int numberOfInstitutes;
	
	@Column
	private int numberOfStudents;
//	
	@Column
	private String adress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNumberOfInstitutes() {
		return numberOfInstitutes;
	}

	public void setNumberOfInstitutes(int numberOfInstitutes) {
		this.numberOfInstitutes = numberOfInstitutes;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Univercity [id=" + id + ", name=" + name + ", level=" + level + ", numberOfInstitutes="
				+ numberOfInstitutes + ", numberOfStudents=" + numberOfStudents + ", adress=" + adress + "]";
	}

	
	
	
}
