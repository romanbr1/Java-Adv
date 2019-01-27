package ua.lviv.lgs.domain;

import java.util.Date;

public class Bucket {
	private int id;
	private int user_id;
	private int magazine_id;
	private String purchase;
	private Date purchase_time;
	
	public Bucket(int id, int user_id, int magazine_id, String purchase, Date purchase_time) {
		this.id = id;
		this.user_id = user_id;
		this.magazine_id = magazine_id;
		this.purchase = purchase;
		this.purchase_time = purchase_time;
	}
	public Bucket(int user_id, int magazine_id, String purchase, Date purchase_time) {
		this.user_id = user_id;
		this.magazine_id = magazine_id;
		this.purchase = purchase;
		this.purchase_time = purchase_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMagazine_id() {
		return magazine_id;
	}
	public void setMagazine_id(int magazine_id) {
		this.magazine_id = magazine_id;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public Date getPurchase_time() {
		return purchase_time;
	}
	public void setPurchase_time(Date purchase_time) {
		this.purchase_time = purchase_time;
	}
	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user_id=" + user_id + ", magazine_id=" + magazine_id + ", purchase=" + purchase
				+ ", purchase_time=" + purchase_time + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + magazine_id;
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + ((purchase_time == null) ? 0 : purchase_time.hashCode());
		result = prime * result + user_id;
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
		Bucket other = (Bucket) obj;
		if (id != other.id)
			return false;
		if (magazine_id != other.magazine_id)
			return false;
		if (purchase == null) {
			if (other.purchase != null)
				return false;
		} else if (!purchase.equals(other.purchase))
			return false;
		if (purchase_time == null) {
			if (other.purchase_time != null)
				return false;
		} else if (!purchase_time.equals(other.purchase_time))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
}


