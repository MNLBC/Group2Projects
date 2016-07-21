package com.oocl.mnlbc.dao.inf;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface FavoriteItemsDAO {

	public List<Product> getFavoriteItemsById(long userId);
	public int deleteFavoriteItem(long userId,long prodId);
	public int addFavoriteItem(long userId,long prodId);
}
