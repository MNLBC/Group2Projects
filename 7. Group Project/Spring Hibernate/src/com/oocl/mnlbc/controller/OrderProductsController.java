package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderProductSVC;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;

public class OrderProductsController {

	private OrderProductSVC orderprodSvc;

	@Autowired(required = true)
	@Qualifier(value = "orderProductService")
	public void setOrderProdService(OrderProductSVC op) {
		this.orderprodSvc = op;
	}
	
	@RequestMapping(value = "/getRelatedProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> listRelatedProducts(@RequestParam("order") Order order) {
		return this.orderprodSvc.getRelatedProducts(order);
	}

	@RequestMapping(value = "/getCartProducts/{id}", method = RequestMethod.GET)
	public @ResponseBody List<CartProduct> listCartProducts(@PathVariable("id") String id) {
		return this.orderprodSvc.getCartProducts(id);
	}
}
