package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.OrdersSVC;
import com.oocl.mnlbc.model.Order;

@Controller
public class OrderController {

	private OrdersSVC orderSvc;

	@Autowired(required = true)
	@Qualifier(value = "ordersService")
	public void setOrderService(OrdersSVC os) {
		this.orderSvc = os;
	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public @ResponseBody int createOrder(@RequestBody Order order) {
		if (order != null) {
			return this.orderSvc.createOrder(order);
		}
		return 0;
	}

	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public @ResponseBody int cancelOrder(@RequestBody Order order) {
		if (order != null) {
			return this.orderSvc.cancelOrder(order);
		}
		return 0;
	}
}
