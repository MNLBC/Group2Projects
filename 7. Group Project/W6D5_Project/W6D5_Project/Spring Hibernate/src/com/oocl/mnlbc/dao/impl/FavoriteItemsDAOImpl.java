package com.oocl.mnlbc.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.FavoriteItemsDAO;
import com.oocl.mnlbc.model.FavoriteItems;
import com.oocl.mnlbc.model.Product;

/**
 * DAO Implementation for FAVORITEITEMS Table
 * @author KALINWI2
 * @since 21-JUL-2016
 */

@Repository
@Transactional
public class FavoriteItemsDAOImpl implements FavoriteItemsDAO {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Product> getFavoriteItemsById(long userId) {
		List<Product> result = new ArrayList<Product>();
		Query query = manager.createNativeQuery("SELECT A.* FROM PRODUCT A, FAVORITEITEMS B WHERE A.PRODID = B.PRODID AND B.USERID = '" + userId + "'");
		List<Object[]> obj = query.getResultList();
		for(Object[] o : obj){
			Product prod = new Product();
			BigDecimal d = (BigDecimal) o[0];
			prod.setProdId(d.longValue());
			prod.setProdName((String)o[1]);
			prod.setProdCat((String)o[2]);
			prod.setProdDesc((String)o[3]);
			d = (BigDecimal) o[4];
			prod.setProdPrice(d.floatValue());
			d = (BigDecimal) o[5];
			prod.setProdSale(d.floatValue());
			d = (BigDecimal) o[6];
			prod.setProdStock(d.intValue());
			prod.setProdImg((String)o[7]);
			result.add(prod);
		}
		return result;
	}

	@Override
	public int deleteFavoriteItem(long userId, long prodId) {
		int result = 0;
		try{
			List<FavoriteItems> removeList = new ArrayList<FavoriteItems>();
			result = manager.createNativeQuery("DELETE FROM FAVORITEITEMS WHERE USERID = '" + userId + "' "
					+ "AND PRODID = '" + prodId + "'").executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addFavoriteItem(long userId, long prodId) {
		int result = 0;
		try{
			List<FavoriteItems> removeList = new ArrayList<FavoriteItems>();
			result = manager.createNativeQuery("INSERT INTO FAVORITEITEMS(PRODID,USERID) VALUES('" + prodId + "','" + userId +"')").executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
