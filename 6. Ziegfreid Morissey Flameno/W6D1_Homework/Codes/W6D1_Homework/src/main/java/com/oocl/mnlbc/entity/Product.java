package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * product entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

   @Id
   // (strategy = GenerationType.AUTO)
   @Column(name = "product_id")
   private String productId;
   @Column(name = "product_name")
   private String productName;
   @JoinColumn(name = "product_id", referencedColumnName = "product_id")
   @ManyToMany(fetch = FetchType.LAZY)
   private Book productBookId;

   public Product() {
   }

   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public Book getProductBookId() {
      return productBookId;
   }

   public void setProductBookId(Book productBookId) {
      this.productBookId = productBookId;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (productId != null ? productId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Product)) {
         return false;
      }
      Product other = (Product) object;
      if ((this.productId == null && other.productId != null)
         || (this.productId != null && !this.productId.equals(other.productId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Product{" + "productId=" + productId + ", productName=" + productId + "}";
   }
}
