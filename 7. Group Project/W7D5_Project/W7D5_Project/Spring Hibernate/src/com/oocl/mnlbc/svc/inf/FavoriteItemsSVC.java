package com.oocl.mnlbc.svc.inf;

import java.util.List;

import com.oocl.mnlbc.model.Product;

public interface FavoriteItemsSVC {

	public List<Product> getFavoriteItemsById(long userId);

	public int deleteFavoriteItem(long userId, long prodId);

	public int addFavoriteItem(long userId, long prodId);

}
