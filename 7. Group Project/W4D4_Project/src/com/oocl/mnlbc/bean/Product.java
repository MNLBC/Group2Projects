/**
 * 
 */
package com.oocl.mnlbc.bean;

/**
 * @author Kassandra Fuentes
 *
 */
public class Product {

   private long productId;
   private String productName;
   private String productDesc;
   private double productPrice;
   private String productImg;
   private String productCategory;
   private int productStock;

   /**
    * @return the productId
    */
   public long getProductId() {
      return productId;
   }

   /**
    * @param productId
    *           the productId to set
    */
   public void setProductId(long productId) {
      this.productId = productId;
   }

   /**
    * @return the productName
    */
   public String getProductName() {
      return productName;
   }

   /**
    * @param productName
    *           the productName to set
    */
   public void setProductName(String productName) {
      this.productName = productName;
   }

   /**
    * @return the productDesc
    */
   public String getProductDesc() {
      return productDesc;
   }

   /**
    * @param productDesc
    *           the productDesc to set
    */
   public void setProductDesc(String productDesc) {
      this.productDesc = productDesc;
   }

   /**
    * @return the productPrice
    */
   public double getProductPrice() {
      return productPrice;
   }

   /**
    * @param productPrice
    *           the productPrice to set
    */
   public void setProductPrice(double productPrice) {
      this.productPrice = productPrice;
   }

   /**
    * @return the productImg
    */
   public String getProductImg() {
      return productImg;
   }

   /**
    * @param productImg
    *           the productImg to set
    */
   public void setProductImg(String productImg) {
      this.productImg = productImg;
   }

   /**
    * @return the productCategory
    */
   public String getProductCategory() {
      return productCategory;
   }

   /**
    * @param productCategory
    *           the productCategory to set
    */
   public void setProductCategory(String productCategory) {
      this.productCategory = productCategory;
   }

   /**
    * @return the productStock
    */
   public int getProductStock() {
      return productStock;
   }

   /**
    * @param productStock
    *           the productStock to set
    */
   public void setProductStock(int productStock) {
      this.productStock = productStock;
   }

}
