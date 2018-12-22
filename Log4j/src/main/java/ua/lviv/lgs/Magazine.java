package ua.lviv.lgs;

public class Magazine {
private int id;
private String title;
private String category;
public Magazine(int id, String title, String category) {
	this.id = id;
	this.title = title;
	this.category = category;
}
public Magazine(String title, String category) {
	this.title = title;
	this.category = category;
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
