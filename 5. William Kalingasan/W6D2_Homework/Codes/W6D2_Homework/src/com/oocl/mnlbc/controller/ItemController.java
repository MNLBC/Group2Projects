package com.oocl.mnlbc.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

@Controller
@ResponseBody
public class ItemController {
	
	@RequestMapping(value = "/GET/item/{id}")
	public Item getItem(@PathVariable("id") int id){
		Item item = null;
		ItemService iService = new ItemService();
		iService.init();
		EntityManager em = iService.getEntityManager();
		item = iService.getItemById(em, id);
		return item;
	}
}
