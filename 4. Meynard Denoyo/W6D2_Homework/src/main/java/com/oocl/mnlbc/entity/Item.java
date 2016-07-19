package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

   @Id
   @Column(name = "item_id")
   private String id;
   @Column(name = "item_name")
   private String itemname;
   @Column(name = "item_category")
   private String category;
   @Column(name = "item_stock")
   private int stock;
   @Column(name = "item_price")
   private int price;
   
   public String getId() {
      return id;
   }
   
   public void setId(String id) {
      this.id = id;
   }
   
   public String getItemname() {
      return itemname;
   }
   
   public void setItemname(String itemname) {
      this.itemname = itemname;
   }
   
   public String getCategory() {
      return category;
   }
   
   public void setCategory(String category) {
      this.category = category;
   }
   
   public int getStock() {
      return stock;
   }
   
   public void setStock(int stock) {
      this.stock = stock;
   }
   
   public int getPrice() {
      return price;
   }
   
   public void setPrice(int price) {
      this.price = price;
   }

   
}
