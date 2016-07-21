/**
 * 
 */
package com.oocl.mnlbc.model;

/**
 * Cart Product Model
 * 
 * @author Danna Soquiat
 * @since 2016-07-15
 *
 */
public class CartProduct extends Product {


	private int prodQty;
	private float prodSubtotal;

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public double getProdSubtotal() {
		return prodSubtotal;
	}

	public void setProdSubtotal(float prodSubtotal) {
		this.prodSubtotal = prodSubtotal;
	}

}
