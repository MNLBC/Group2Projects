/**
 * 
 */
package com.oocl.mnlbc.bean;

/**
 * Cart Product Model
 * 
 * @author Ziggy
 * @since 2016-07-11
 *
 */
public class CartProduct extends Product {

   private int prodQty;

   public int getProdQty() {
      return prodQty;
   }

   public void setProdQty(int prodQty) {
      this.prodQty = prodQty;
   }

}
