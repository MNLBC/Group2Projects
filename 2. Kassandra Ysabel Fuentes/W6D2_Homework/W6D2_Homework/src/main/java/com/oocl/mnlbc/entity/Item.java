package com.oocl.mnlbc.entity;

/**
 * @author fuentka
 * @since 07/19/2016
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	@Id
	@Column(name = "item_id")
	private String item_id;
	@Column(name = "item_name")
	private String item_name;
	@Column(name = "item_category")
	private String item_category;
	@Column(name = "item_stock")
	private Integer item_stock;
	@Column(name = "item_price")
	private Integer item_price;

	public Item() {
	}

	public Item(String item_id) {
		this.item_id = item_id;
	}

	
	public Item(String item_id, String item_name, String item_category) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_category = item_category;
	}

	/**
	 * @return the item_id
	 */
	public String getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id
	 *            the item_id to set
	 */
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return the item_name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * @param item_name
	 *            the item_name to set
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * @return the item_category
	 */
	public String getItem_category() {
		return item_category;
	}

	/**
	 * @param item_category
	 *            the item_category to set
	 */
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	/**
	 * @return the item_stock
	 */
	public Integer getItem_stock() {
		return item_stock;
	}

	/**
	 * @param item_stock
	 *            the item_stock to set
	 */
	public void setItem_stock(Integer item_stock) {
		this.item_stock = item_stock;
	}

	/**
	 * @return the item_price
	 */
	public Integer getItem_price() {
		return item_price;
	}

	/**
	 * @param item_price
	 *            the item_price to set
	 */
	public void setItem_price(Integer item_price) {
		this.item_price = item_price;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (item_id != null ? item_id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Item)) {
			return false;
		}
		Item other = (Item) object;
		if ((this.item_id == null && other.item_id != null)
				|| (this.item_id != null && !this.item_id.equals(other.item_id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Item{" + "itemId=" + item_id + "itemName=" + item_name + ", itemCategory='" + item_category + '\''
				+ '}';
	}
}
