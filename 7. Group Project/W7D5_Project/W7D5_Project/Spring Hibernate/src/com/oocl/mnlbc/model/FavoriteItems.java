package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity Model for FAVORITEITEMS Table
 * @author KALINWI2
 *
 */

@Entity
@Table(name = "FAVORITEITEMS")
public class FavoriteItems {

	@Id
	@Column(name = "FAVEITEMID")
	@SequenceGenerator(name = "favorite_seq", sequenceName = "FAVORITEITEMS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "favorite_seq", strategy = GenerationType.SEQUENCE)
	private int favoriteItemId;
	@Column(name= "USERID")
	private int userId;
	@Column(name= "PRODID")
	private int prodId;
	
	public FavoriteItems(){
		
	}
	
	public int getFavoriteItemId() {
		return favoriteItemId;
	}
	public void setFavoriteItemId(int favoriteItemId) {
		this.favoriteItemId = favoriteItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	
}
