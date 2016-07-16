package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;

import com.oocl.mnlbc.dao.ProductSVC;

@Controller
public class ProductsController {

	private ProductSVC prodSvc;

	@Autowired(required = true)
	@Qualifier(value = "prodSvc")
	public void setProdService(ProductSVC ps) {
		this.prodSvc = ps;
	}

}
