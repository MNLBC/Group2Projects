package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ProductSVC;
import com.oocl.mnlbc.model.Product;

@Controller
public class ProductsController {

	private ProductSVC prodSvc;

	@Autowired(required = true)
	@Qualifier(value = "prodSvc")
	public void setProdService(ProductSVC ps) {
		this.prodSvc = ps;
	}

	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	public @ResponseBody List<Product> listProducts() {
		return this.prodSvc.getProducts();
	}

	@RequestMapping(value = "/getProductsByCategory", method = RequestMethod.GET)
	public @ResponseBody List<Product> listProductsByCat(@RequestParam("category") String cat) {
		return this.prodSvc.getProductsByCategory(cat);
	}

	// For add and update person both
	// @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	// public String addPerson(@ModelAttribute("person") Person p) {
	//
	// if (p.getId() == 0) {
	// // new person, add it
	// this.personService.addPerson(p);
	// } else {
	// // existing person, call update
	// this.personService.updatePerson(p);
	// }
	//
	// return "redirect:/persons";
	//
	// }
	//
	// @RequestMapping("/remove/{id}")
	// public String removePerson(@PathVariable("id") int id) {
	//
	// this.personService.removePerson(id);
	// return "redirect:/persons";
	// }
	//
	// @RequestMapping("/edit/{id}")
	// public String editPerson(@PathVariable("id") int id, Model model) {
	// model.addAttribute("person", this.personService.getPersonById(id));
	// model.addAttribute("listPersons", this.personService.listPersons());
	// return "person";
	// }

}
