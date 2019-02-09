package ua.lviv.lgs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "bucket")
public class Bucket {
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;

	@ManyToOne
	@JoinColumn(name="magazine_id", referencedColumnName="id")
	private Magazine magazine;
	
	@Column(name = "purchase")
	private String purchase;
	
	@Column(name = "purchase_time")
	private Date purchase_time;

	
	public Bucket(String id, User user, Magazine magazine, String purchase, Date purchase_time) {
		super();
		this.id = id;
		this.user = user;
		this.magazine = magazine;
		this.purchase = purchase;
		this.purchase_time = purchase_time;
	}

	public Bucket( Magazine magazine, String purchase, Date purchase_time, User user) {
		this.user = user;
		this.magazine = magazine;
		this.purchase = purchase;
		this.purchase_time = purchase_time;
	}

	public Bucket() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
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
		return "Bucket [id=" + id + ", user=" + user + ", magazine=" + magazine + ", purchase=" + purchase
				+ ", purchase_time=" + purchase_time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + ((purchase_time == null) ? 0 : purchase_time.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (magazine == null) {
			if (other.magazine != null)
				return false;
		} else if (!magazine.equals(other.magazine))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
}


