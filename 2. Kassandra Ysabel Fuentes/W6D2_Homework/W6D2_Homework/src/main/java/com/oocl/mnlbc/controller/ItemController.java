package com.oocl.mnlbc.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

/**
 * @author fuentka
 * @since 07/19/2016
 */
@RestController
public class ItemController {

	/**
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("/getItemById")
	public Item getItem(@RequestParam("id") int itemId) {
		Item item = new Item();

		item.setItem_id("322");
		item.setItem_name("Item 000");
		item.setItem_category("Category 000");
		item.setItem_stock(223);
		item.setItem_price(322);
		
		return item;
	}
	
	@RequestMapping("/getItemFromDB/{id}")
	public Item getItemById(@PathVariable("id") String itemId) {
		ItemService i = new ItemService();
		i.init();
		EntityManager em = i.getEntityManager();
		Item item = i.getItem(em, itemId);
		return item;
	}
	
	
}
