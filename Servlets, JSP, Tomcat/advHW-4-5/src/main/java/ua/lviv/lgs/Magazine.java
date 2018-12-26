package ua.lviv.lgs;

public class Magazine {
private int id;
private String title;
private String category;
private float price;

public Magazine(int id, String title, String category, float price) {
	this.id = id;
	this.title = title;
	this.category = category;
	this.price=price;
}
public Magazine(String title, String category, float price) {
	this.title = title;
	this.category = category;
	this.price=price;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "Magazine [id=" + id + ", title=" + title + ", category=" + category + "]";
}


}
