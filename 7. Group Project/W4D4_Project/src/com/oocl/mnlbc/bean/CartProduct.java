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
	private double prodSubtotal;

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public double getProdSubtotal() {
		return prodSubtotal;
	}

	public void setProdSubtotal(double prodSubtotal) {
		this.prodSubtotal = prodSubtotal;
	}

}
