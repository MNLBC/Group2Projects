package com.oocl.mnlbc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity(name="Product")
@Table(name="Product")
public class Product  implements java.io.Serializable {
	
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_ITEM_SEQUENCE")
    private long id;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
//    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "CATEGAORY_ITEM", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "CATE_ID"))
    private List<Book> cateGory = new ArrayList<Book>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getCateGory() {
		return cateGory;
	}

	public void setCateGory(List<Book> cateGory) {
		this.cateGory = cateGory;
	}
   
}
