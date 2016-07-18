package com.oocl.mnlbc.item3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="W6D1_Product")
public class Product {

	@Id
	@Column(name = "PROD_ID")
	private String productId;
	@Column(name = "PROD_NAME")
	private String productName;
	@JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
	@ManyToMany(fetch = FetchType.LAZY)
	private Book productBookId;
	
	public Product(){
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Book getProductBookId() {
		return productBookId;
	}

	public void setProductBookId(Book productBookId) {
		this.productBookId = productBookId;
	}
	
	
}
