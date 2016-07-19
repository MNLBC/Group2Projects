package com.oocl.mnlbc.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.Service.ItemService;
import com.oocl.mnlbc.entity.Item;

@Controller
@ResponseBody
public class ItemController {

   @RequestMapping(value="/GET/item/{id}")
   public List<Item> listItemById(@PathVariable("id") String id){
      Item item = new Item();
      ItemService itemservice = new ItemService();
      itemservice.init();
      EntityManager em = itemservice.getEntityManager();
      List<Item> result = itemservice.getItemsById(id);
      
      return result;
   }
}
