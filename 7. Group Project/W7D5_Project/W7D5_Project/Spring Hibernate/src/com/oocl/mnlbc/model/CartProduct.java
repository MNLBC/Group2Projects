/**
 * 
 */
package com.oocl.mnlbc.model;

import java.io.Serializable;

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
 * @desc Hibernate Migration to Cart Product Model
 * 
 */
@Entity
@Table(name = "CARTPRODUCT")
public class CartProduct implements Serializable {

   @Id
   @Column(name = "CARTPRODID")
   @SequenceGenerator(name = "cartprod_seq", sequenceName = "CARTPRODUCT_SEQ", allocationSize = 1)
   @GeneratedValue(generator = "cartprod_seq", strategy = GenerationType.SEQUENCE)
   private long cartprodId;
   @Column(name = "USERID")
   private long userId;
   @Column(name = "PRODID")
   private long prodId;
   @Column(name = "PRODNAME")
   private String prodName;
   @Column(name = "PRODCAT")
   private String prodCat;
   @Column(name = "PRODDESC")
   private String prodDesc;
   @Column(name = "PRODPRICE")
   private float prodPrice;
   @Column(name = "PRODSALE")
   private float prodSale;
   @Column(name = "PRODSTOCK")
   private int prodStock;
   @Column(name = "PRODIMG")
   private String prodImg;
   @Column(name = "PRODQTY")
   private int prodQty;
   @Column(name = "PRODSUBTOTAL")
   private float prodSubtotal;

   public long getCartprodId() {
      return cartprodId;
   }

   public void setCartprodId(long cartprodId) {
      this.cartprodId = cartprodId;
   }

   public int getProdQty() {
      return prodQty;
   }

   public void setProdQty(int prodQty) {
      this.prodQty = prodQty;
   }

   /**
    * @return the userId
    */
   public long getUserId() {
      return userId;
   }

   /**
    * @param userId
    *           the userId to set
    */
   public void setUserId(long userId) {
      this.userId = userId;
   }

   /**
    * @return the prodId
    */
   public long getProdId() {
      return prodId;
   }

   /**
    * @param prodId
    *           the prodId to set
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
    *           the prodName to set
    */
   public void setProdName(String prodName) {
      this.prodName = prodName;
   }

   /**
    * @return the prodCat
    */
   public String getProdCat() {
      return prodCat;
   }

   /**
    * @param prodCat
    *           the prodCat to set
    */
   public void setProdCat(String prodCat) {
      this.prodCat = prodCat;
   }

   /**
    * @return the prodDesc
    */
   public String getProdDesc() {
      return prodDesc;
   }

   /**
    * @param prodDesc
    *           the prodDesc to set
    */
   public void setProdDesc(String prodDesc) {
      this.prodDesc = prodDesc;
   }

   /**
    * @return the prodPrice
    */
   public float getProdPrice() {
      return prodPrice;
   }

   /**
    * @param prodPrice
    *           the prodPrice to set
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
    *           the prodSale to set
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
    *           the prodStock to set
    */
   public void setProdStock(int prodStock) {
      this.prodStock = prodStock;
   }

   /**
    * @return the prodImg
    */
   public String getProdImg() {
      return prodImg;
   }

   /**
    * @param prodImg
    *           the prodImg to set
    */
   public void setProdImg(String prodImg) {
      this.prodImg = prodImg;
   }

   /**
    * @return the prodSubtotal
    */
   public float getProdSubtotal() {
      return prodSubtotal;
   }

   /**
    * @param prodSubtotal
    *           the prodSubtotal to set
    */
   public void setProdSubtotal(float prodSubtotal) {
      this.prodSubtotal = prodSubtotal;
   }

}
