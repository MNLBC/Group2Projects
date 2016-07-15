/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * @author Kassandra Fuentes
 *
 */
public class Product {

   private long prodId;
   private String prodName;
   private String prodDesc;
   private String prodCat;
   private String prodImg;
   private double prodPrice;
   private double prodSale;
   private int prodStock;

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
    * @return the prodPrice
    */
   public double getProdPrice() {
      return prodPrice;
   }

   /**
    * @param prodPrice
    *           the prodPrice to set
    */
   public void setProdPrice(double prodPrice) {
      this.prodPrice = prodPrice;
   }

   /**
    * @return the prodSale
    */
   public double getProdSale() {
      return prodSale;
   }

   /**
    * @param prodSale
    *           the prodSale to set
    */
   public void setProdSale(double prodSale) {
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

}
