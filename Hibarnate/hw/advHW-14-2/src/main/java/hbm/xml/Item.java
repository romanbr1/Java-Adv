package hbm.xml;

import java.util.HashSet;
import java.util.Set;

public class Item {
private Integer id;
private String itemId;
private String itemTotal;
private Integer quantity;
private Set<Cart> carts = new HashSet<>();
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getItemTotal() {
	return itemTotal;
}
public void setItemTotal(String itemTotal) {
	this.itemTotal = itemTotal;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Set<Cart> getCarts() {
	return carts;
}
public void setCarts(Set<Cart> carts) {
	this.carts = carts;
}
public Item(Integer id, String itemId, String itemTotal, Integer quantity, Set<Cart> carts) {
	
	this.id = id;
	this.itemId = itemId;
	this.itemTotal = itemTotal;
	this.quantity = quantity;
	this.carts = carts;
}
public Item(String itemId, String itemTotal, Integer quantity) {
	
	this.itemId = itemId;
	this.itemTotal = itemTotal;
	this.quantity = quantity;
	
}
public Item() {
	
}




}
