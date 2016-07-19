package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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


   @RequestMapping("/GET/item/{id}")
   public Item getItemFromDb(@PathVariable(value = "id") String itemId) {
      ItemService is = new ItemService();
      is.init();
      EntityManager em = is.getEntityManager();
      Item fromDb = is.getItemInfo(em, itemId);
      return fromDb;
   }
}
