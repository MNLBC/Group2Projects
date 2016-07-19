package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.dao.ProductDAOImpl;
import com.oocl.mnlbc.model.Product;

@Controller
@ResponseBody
public class ProductsController {

	@RequestMapping(value = "/GET/product/{id}")
	public @ResponseBody Product getProduct(@PathVariable(value = "id") String id) {
		ProductDAO dao = new ProductDAOImpl();
		Product product = new Product();

		dao.init();
		EntityManager entity = dao.getEntityManager();

		product = dao.getProductById(entity, id);

		return product;

	}

}
