package ua.lviv.lgs.domain;

public class Magazine {
private int id;
private String title;
private String category;
private float price;

public Magazine(int id, String title, String category, float purchasePrice) {
	this.id = id;
	this.title = title;
	this.category = category;
	this.price=purchasePrice;
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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((category == null) ? 0 : category.hashCode());
	result = prime * result + id;
	result = prime * result + Float.floatToIntBits(price);
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Magazine other = (Magazine) obj;
	if (category == null) {
		if (other.category != null)
			return false;
	} else if (!category.equals(other.category))
		return false;
	if (id != other.id)
		return false;
	if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}


}
