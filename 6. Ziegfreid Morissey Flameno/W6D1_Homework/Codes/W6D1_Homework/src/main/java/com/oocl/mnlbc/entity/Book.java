package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * book entity
 * 
 * @author flamezi2
 * @since 2016-07-18
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

   @Id
   // (strategy = GenerationType.AUTO)
   @Column(name = "book_id")
   private String bookId;
   @Column(name = "book_name")
   private String bookName;
   @JoinColumn(name = "product_id", referencedColumnName = "product_id")
   @ManyToMany(fetch = FetchType.LAZY)
   private Product productId;

   public Book() {
   }

   public String getBookId() {
      return bookId;
   }

   public void setBookId(String bookId) {
      this.bookId = bookId;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public Product getProductId() {
      return productId;
   }

   public void setProductId(Product productId) {
      this.productId = productId;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (bookId != null ? bookId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Book)) {
         return false;
      }
      Book other = (Book) object;
      if ((this.bookId == null && other.bookId != null)
         || (this.bookId != null && !this.bookId.equals(other.bookId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", productId=" + productId + " }";
   }
}
