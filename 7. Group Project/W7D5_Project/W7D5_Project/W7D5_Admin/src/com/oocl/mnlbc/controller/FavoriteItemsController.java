package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.FavoriteItemsSVC;

/**
 * Controller for FAVORITEITEMS
 * @author KALINWI2
 * @since 21-JUL-2016
 */
@RestController
public class FavoriteItemsController {

	private FavoriteItemsSVC favoriteService;
	
	@Autowired(required = true)
	@Qualifier(value = "favoriteService")
	public void setFavoriteService(FavoriteItemsSVC favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@RequestMapping(value = "/favoriteItems", method = RequestMethod.POST)
	public @ResponseBody List<Product> getFavoriteItemsById(@RequestParam("userId") long userId){
		if(userId > 0){
			return favoriteService.getFavoriteItemsById(userId);
		}
		return null;
	}
	
	@RequestMapping(value = "/deleteFavoriteItems", method = RequestMethod.POST)
	public @ResponseBody String deleteFavoriteItem(@RequestParam("userId") long userId, @RequestParam("prodId") long prodId){
		if(favoriteService.deleteFavoriteItem(userId, prodId)==1){
			return "success";
		}
		else{
			return "failed";
		}
		
	}
	
	@RequestMapping(value = "/addFavoriteItems", method = RequestMethod.POST)
	public @ResponseBody String addFavoriteItem(@RequestParam("userId") long userId, @RequestParam("prodId") long prodId){
		if(favoriteService.addFavoriteItem(userId, prodId)==1){
			return "success";
		}
		else{
			return "failed";
		}
		
	}
}
