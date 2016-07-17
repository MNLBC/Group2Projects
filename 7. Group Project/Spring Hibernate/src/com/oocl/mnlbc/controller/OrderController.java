package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrdersSVC;
import com.oocl.mnlbc.dao.ProductSVC;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.Product;

@Controller
public class OrderController {

	private OrdersSVC orderSvc;
	
	@Autowired(required = true)
	@Qualifier(value = "ordersService")
	public void setOrderService(OrdersSVC os) {
		this.orderSvc = os;
	}
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public @ResponseBody int createOrder(@RequestParam Order order) {
		return this.orderSvc.createOrder(order);
	}
	
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
	public @ResponseBody int cancelOrder(@RequestParam Order order) {
		return this.orderSvc.cancelOrder(order);
	}
}
