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
@ResponseBody
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
    * @return boolean
    */
   @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
   public boolean createProd(@RequestBody Product product) {
      int result = this.prodSVC.addProduct(product);
      if (product != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * updateProd web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
   public boolean updateProd(@RequestBody Product product) {
      int result = this.prodSVC.updateProduct(product);
      if (product != null) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   /**
    * removeProduct web service
    * 
    * @return boolean
    */
   @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
   public boolean removeProduct(@RequestParam long id) {
      int result = this.prodSVC.removeProduct(id);
      if (id >= 0) {
         if (result != 1 || result == 0)
            return false;
         return true;
      }
      return false;
   }

   // public void addProduct(Product p);
   //
   // public void updateProduct(Product p);

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
