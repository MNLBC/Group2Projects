package com.oocl.mnlbc.controller;

import java.awt.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;


@Controller
@ResponseBody
public class ItemController {
		
	@RequestMapping(value="/get/item/{id}")
	public Item getItemById(@PathVariable("id") String itemId) {
		Item item = new Item();
		ItemService is = new ItemService();
		is.init();
		EntityManager em = is.getEntityManager();
		Item result = is.getItemById(itemId);
		
		return result;
	}

}

