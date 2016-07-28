package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.svc.inf.ProductSVC;

/**
 * Handles web services for Product
 * 
 * @author DENOYME
 * @date 2016-07-21
 */
@RestController
public class ProductsController {

	private ProductSVC prodSVC;

	@Autowired(required = true)
	@Qualifier(value = "productService")
	public void setProdService(ProductSVC prodSVC) {
		this.prodSVC = prodSVC;
	}

	/**
	 * getAllProducts web service
	 * 
	 * @return List<Product>
	 */
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> getAllProducts() {
		return this.prodSVC.getProducts();
	}

	/**
	 * getProductsByCategory web service
	 * 
	 * @param category
	 * @return List<Product>
	 */
	@RequestMapping(value = "/getProductsByCategory", method = RequestMethod.POST)
	public List<Product> getProductsByCategory(@RequestParam String category) {
		if (!category.isEmpty()) {
			return this.prodSVC.getProductsByCategory(category);
		}
		return null;
	}

	/**
	 * createProd web service
	 * 
	 * @param product
	 * @return boolean
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public boolean createProd(@RequestBody Product product) {
		boolean result = this.prodSVC.addProduct(product);
		if (product != null) {
			if (result != true || result == false) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * updateProd web service
	 * 
	 * @param product
	 * @return boolean
	 */
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public boolean updateProd(@RequestBody Product product) {
		boolean result = this.prodSVC.updateProduct(product);
		if (product != null) {
			if (result != true || result == false) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * removeProduct web service
	 * 
	 * @param id
	 * @return boolean
	 */
	@RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
	public boolean removeProduct(@RequestParam long id) {
		boolean result = this.prodSVC.removeProduct(id);
		if (id >= 0) {
			if (result != true || result == false) {
				return false;
			}
			return true;
		}
		return false;
	}

}
