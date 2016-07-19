package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Item entity
 * 
 * @author flamezi2
 * @since 2016-07-19
 */
@Entity
@Table(name = "items")
public class Item {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "item_id")
   private String item_id;
   @Column(name = "item_name")
   private String item_name;
   @Column(name = "item_category")
   private String item_category;
   @Column(name = "item_stock")
   private int item_stock;
   @Column(name = "item_price")
   private int item_price;

   public Item() {
   }

   public String getItem_id() {
      return item_id;
   }

   public void setItem_id(String item_id) {
      this.item_id = item_id;
   }

   public String getItem_name() {
      return item_name;
   }

   public void setItem_name(String item_name) {
      this.item_name = item_name;
   }

   public String getItem_category() {
      return item_category;
   }

   public void setItem_category(String item_category) {
      this.item_category = item_category;
   }

   public int getItem_stock() {
      return item_stock;
   }

   public void setItem_stock(int item_stock) {
      this.item_stock = item_stock;
   }

   public int getItem_price() {
      return item_price;
   }

   public void setItem_price(int item_price) {
      this.item_price = item_price;
   }

}
