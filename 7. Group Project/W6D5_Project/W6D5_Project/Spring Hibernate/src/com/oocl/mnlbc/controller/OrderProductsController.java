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

import com.oocl.mnlbc.model.CartProduct;
import com.oocl.mnlbc.model.Order;
import com.oocl.mnlbc.model.OrderProduct;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.OrderProductSVC;

/**
 * Handles web services for OrderProduct
 * @author DENOYME
 * @since 2016-07-21
 */
@RestController
@ResponseBody
public class OrderProductsController {

	private OrderProductSVC orderprodSVC;

	@Autowired(required = true)
	@Qualifier(value = "orderProductService")
	public void setOrderProdService(OrderProductSVC orderprodSVC) {
		this.orderprodSVC = orderprodSVC;
	}

//	@RequestMapping(value = "/getRelatedProducts", method = RequestMethod.GET)
//	public @ResponseBody List<Product> listRelatedProducts(@RequestParam("order") Order order) {
//		if (order != null) {
//			return this.orderprodSvc.getRelatedProducts(order);
//		}
//		return null;
//	}
//
//	@RequestMapping(value = "/getCartProducts", method = RequestMethod.GET)
//	public @ResponseBody List<CartProduct> listCartProducts(@RequestParam("orderid") String id) {
//		if (id != null) {
//			return this.orderprodSvc.getCartProducts(id);
//		}
//		return null;
//	}
	
   /**
    * updateOrderProduct web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/updateOrderProduct", method = RequestMethod.POST)
   public boolean updateOrderProduct(@RequestBody OrderProduct orderproduct) {
      int result = this.orderprodSVC.updateOrderProduct(orderproduct);
      if (orderproduct != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }
   
   /**
    * getOrderProductsByOrder web service
    * 
    * @return List<Product>
    */
   @RequestMapping(value = "/getOrderProductsByOrder", method = RequestMethod.GET)
   public List<Product> getOrderProductsByOrder(@RequestParam long id) {
      if (id >= 0) {
         return this.orderprodSVC.getOrderProductsByOrder(id);
      }
      return null;
   }
}
