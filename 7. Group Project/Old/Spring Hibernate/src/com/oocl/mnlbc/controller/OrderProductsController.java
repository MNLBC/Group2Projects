package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrderProductSVC;
import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;

@Controller
public class OrderProductsController {

	private OrderProductSVC orderprodSvc;

	@Autowired(required = true)
	@Qualifier(value = "orderProductService")
	public void setOrderProdService(OrderProductSVC op) {
		this.orderprodSvc = op;
	}

	@RequestMapping(value = "/getRelatedProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> listRelatedProducts(@RequestParam("order") Order order) {
		if (order != null) {
			return this.orderprodSvc.getRelatedProducts(order);
		}
		return null;
	}

	@RequestMapping(value = "/getCartProducts", method = RequestMethod.GET)
	public @ResponseBody List<CartProduct> listCartProducts(@RequestParam("orderid") String id) {
		if (id != null) {
			return this.orderprodSvc.getCartProducts(id);
		}
		return null;
	}
}
