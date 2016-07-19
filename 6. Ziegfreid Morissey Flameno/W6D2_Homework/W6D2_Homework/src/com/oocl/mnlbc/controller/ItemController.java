package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.ItemService;
import com.oocl.mnlbc.service.UserService;

@RestController
public class ItemController {

   // private static final String template = "Hello, %s!";
   // private final AtomicLong counter = new AtomicLong();
   //
   // @RequestMapping("/greeting")
   // public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
   // return new Greeting(counter.incrementAndGet(), String.format(template, name));
   // }
   //
   // @RequestMapping("/getUserById")
   // public User getUserById(@RequestParam("id") String userId){
   // return new User(userId, "Ziggy", "Flameño");
   // }
   //
   @RequestMapping("/getUserFromDb")
   public User getUserFromDb(@RequestParam("id") String userId) {
      UserService us = new UserService();
      us.init();
      EntityManager em = us.getEntityManager();
      User fromDb = us.getUserInfo(em, userId);
      return fromDb;
   }

   @RequestMapping("/GET/item/{id}")
   public Item getItemFromDb(@PathVariable(value = "id") String itemId) {
      ItemService is = new ItemService();
      is.init();
      EntityManager em = is.getEntityManager();
      Item fromDb = is.getItemInfo(em, itemId);
      return fromDb;
   }
}
