package hbm.xml;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	private Integer id;
	private Integer total;
	private String name;
	private Set<Item> items = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public Cart(String name) {
	
		this.name = name;
		
	}
	public Cart(Integer total, String name) {
		super();
		this.total = total;
		this.name = name;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Cart() {
		
	}
	public Cart(Integer id, String name, Set<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	
	
	
	

}
