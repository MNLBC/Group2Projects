package com.oocl.mnlbc.svc.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oocl.mnlbc.dao.inf.FavoriteItemsDAO;
import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.svc.inf.FavoriteItemsSVC;

/**
 * Service Implementation for FAVORITEITEMS Table
 * @author KALINWI2
 * @since 21-JUL-2016
 *
 */
@Service
public class FavoriteItemsSVCImpl implements FavoriteItemsSVC {
	
	private FavoriteItemsDAO favoriteDAO;
	
	public void setFavoriteDAO(FavoriteItemsDAO favoriteDAO) {
		this.favoriteDAO = favoriteDAO;
	}

	@Override
	@Transactional
	public List<Product> getFavoriteItemsById(long userId) {
		return favoriteDAO.getFavoriteItemsById(userId);
	}

	@Override
	@Transactional
	public int deleteFavoriteItem(long userId, long prodId) {
		return favoriteDAO.deleteFavoriteItem(userId, prodId);
	}

	@Override
	@Transactional
	public int addFavoriteItem(long userId, long prodId) {
		return favoriteDAO.addFavoriteItem(userId, prodId);
	}

}
