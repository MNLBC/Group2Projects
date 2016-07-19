package com.oocl.mnlbc.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

/**
 * Item Controller
 * 
 * @author flamezi2
 * @since 2016-07-19
 */
@RestController
public class ItemController {

   @RequestMapping("/GET/item/all")
   public @ResponseBody List<Item> getAllItemFromDb() {
      ItemService is = new ItemService();
      is.init();
      EntityManager em = is.getEntityManager();
      List<Item> fromDb = is.getAllItemInfo(em);
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
