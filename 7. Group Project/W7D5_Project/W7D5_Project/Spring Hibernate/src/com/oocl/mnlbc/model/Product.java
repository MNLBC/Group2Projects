/**
 * 
 */
package com.oocl.mnlbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Lance Jasper C. Lopez
 * @since 07-21-2016
 * @desc Hibernate Migration to JPA Products Model
 * 
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "PRODID")
	@SequenceGenerator(name = "product_seq", sequenceName = "PRODUCT_SEQ3", allocationSize = 1)
	@GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
	private long prodId;
	@Column(name = "PRODNAME")
	private String prodName;
	@Column(name = "PRODDESC")
	private String prodDesc;
	@Column(name = "PRODCAT")
	private String prodCat;
	@Column(name = "PRODIMG")
	private String prodImg;
	@Column(name = "PRODPRICE")
	private float prodPrice;
	@Column(name = "PRODSALE")
	private float prodSale;
	@Column(name = "PRODSTOCK")
	private int prodStock;

	/**
	 * @return the prodId
	 */
	public long getProdId() {
		return prodId;
	}

	/**
	 * @param prodId
	 *            the prodId to set
	 */
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the prodDesc
	 */
	public String getProdDesc() {
		return prodDesc;
	}

	/**
	 * @param prodDesc
	 *            the prodDesc to set
	 */
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	/**
	 * @return the prodCat
	 */
	public String getProdCat() {
		return prodCat;
	}

	/**
	 * @param prodCat
	 *            the prodCat to set
	 */
	public void setProdCat(String prodCat) {
		this.prodCat = prodCat;
	}

	/**
	 * @return the prodImg
	 */
	public String getProdImg() {
		return prodImg;
	}

	/**
	 * @param prodImg
	 *            the prodImg to set
	 */
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	/**
	 * @return the prodPrice
	 */
	public float getProdPrice() {
		return prodPrice;
	}

	/**
	 * @param prodPrice
	 *            the prodPrice to set
	 */
	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	/**
	 * @return the prodSale
	 */
	public float getProdSale() {
		return prodSale;
	}

	/**
	 * @param prodSale
	 *            the prodSale to set
	 */
	public void setProdSale(float prodSale) {
		this.prodSale = prodSale;
	}

	/**
	 * @return the prodStock
	 */
	public int getProdStock() {
		return prodStock;
	}

	/**
	 * @param prodStock
	 *            the prodStock to set
	 */
	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}

	/**
	 * @param prodId
	 * @param prodName
	 * @param prodDesc
	 * @param prodCat
	 * @param prodImg
	 * @param prodPrice
	 * @param prodSale
	 * @param prodStock
	 */
	public Product(long prodId, String prodName, String prodDesc, String prodCat, String prodImg, float prodPrice,
			float prodSale, int prodStock) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodCat = prodCat;
		this.prodImg = prodImg;
		this.prodPrice = prodPrice;
		this.prodSale = prodSale;
		this.prodStock = prodStock;
	}

	public Product() {

	}
}
