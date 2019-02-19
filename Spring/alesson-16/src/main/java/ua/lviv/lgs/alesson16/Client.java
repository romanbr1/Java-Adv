package ua.lviv.lgs.alesson16;

import org.springframework.beans.factory.annotation.Autowired;



public class Client {
	private int id;

	 public Client(User user) {
	this.user=user;	
	}
	
	@Autowired
	private User user;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", user=" + user + "]";
	}
	
	
}
