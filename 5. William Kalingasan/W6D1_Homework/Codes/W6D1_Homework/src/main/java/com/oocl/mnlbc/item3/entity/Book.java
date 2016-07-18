package com.oocl.mnlbc.item3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="W6D1_Book")
public class Book {
	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private String bookId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID")
	@ManyToMany(fetch = FetchType.LAZY)
	private Product productId;
	
	public Book(){
		
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}
	
	

}
