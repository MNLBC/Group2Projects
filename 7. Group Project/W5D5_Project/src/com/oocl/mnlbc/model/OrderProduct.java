/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * @author Danna Soquiat
 *
 */
public class OrderProduct {

   private long orderProdId;
   private long orderId;
   private long prodId;
   private int orderProdQty;

   /**
    * @return the orderProdId
    */
   public long getOrderProdId() {
      return orderProdId;
   }

   /**
    * @param orderProdId
    *           the orderProdId to set
    */
   public void setOrderProdId(long orderProdId) {
      this.orderProdId = orderProdId;
   }

   /**
    * @return the orderId
    */
   public long getOrderId() {
      return orderId;
   }

   /**
    * @param orderId
    *           the orderId to set
    */
   public void setOrderId(long orderId) {
      this.orderId = orderId;
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
    * @return the orderProdQty
    */
   public int getOrderProdQty() {
      return orderProdQty;
   }

   /**
    * @param orderProdQty
    *           the orderProdQty to set
    */
   public void setOrderProdQty(int orderProdQty) {
      this.orderProdQty = orderProdQty;
   }

}
