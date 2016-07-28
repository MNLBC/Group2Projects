package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.inf.CartProductDAO;
import com.oocl.mnlbc.model.CartProduct;

/**
 * JPA DAO Implementation for CartProduct TABLE
 * 
 * @author DENOYME
 * @since 2016-07-22
 */

/**
 * 
 * @author Lance Jasper Lopez
 * @since 07/27/2016
 * @desc JPA Query Modification to prevent SQL Injection
 *
 */
@Repository
@Transactional
public class CartProductDAOImpl implements CartProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(CartProductDAOImpl.class);

	@PersistenceContext
	private EntityManager manager;

	@Override
	public int createCartProduct(CartProduct cartproduct) {
		manager.persist(cartproduct);
		logger.info("CartProduct saved successfully, cartproduct details=" + cartproduct);
		return 1;
	}

	@Override
	public int updateCartProduct(long cartprodid, CartProduct cartproduct) {
		CartProduct newCartProduct = manager.find(CartProduct.class, cartprodid);
		newCartProduct.setCartprodId(cartprodid);
		newCartProduct.setUserId(cartproduct.getUserId());
		newCartProduct.setProdId(cartproduct.getProdId());
		newCartProduct.setProdName(cartproduct.getProdName());
		newCartProduct.setProdCat(cartproduct.getProdCat());
		newCartProduct.setProdDesc(cartproduct.getProdDesc());
		newCartProduct.setProdPrice(cartproduct.getProdPrice());
		newCartProduct.setProdSale(cartproduct.getProdSale());
		newCartProduct.setProdStock(cartproduct.getProdStock());
		newCartProduct.setProdImg(cartproduct.getProdImg());
		newCartProduct.setProdQty(cartproduct.getProdQty());
		newCartProduct.setProdSubtotal(cartproduct.getProdSubtotal());
		logger.info("CartProduct updated successfully, cartproduct details=" + newCartProduct);
		return 1;
	}

	@Override
	public int deleteCartProductsByUser(long userid) {
		String sql = "SELECT cartproduct FROM CartProduct cartproduct WHERE cartproduct.userId = :userId";
		Query query = manager.createQuery(sql);
		query.setParameter("userId", userid);
		List<CartProduct> deletedcartprod = query.getResultList();
		logger.info("User ID = " + userid);
		for (CartProduct cartproduct : deletedcartprod) {
			manager.remove(cartproduct);
			logger.info("CartProduct deleted successfully!=" + cartproduct);
		}
		return 1;
	}

	@Override
	public List<CartProduct> getCartProductsByUser(long userid) {
		String sql = "SELECT cartproduct FROM CartProduct cartproduct WHERE cartproduct.userId = :userId";
		Query query = manager.createQuery(sql);
		query.setParameter("userId", userid);
		List<CartProduct> cartproductlist = query.getResultList();
		logger.info("User ID = " + userid);
		for (CartProduct cartproduct : cartproductlist) {
			logger.info("CartProduct list =" + cartproduct);
		}
		return cartproductlist;
	}

	@Override
	public List<CartProduct> checkCartProduct(CartProduct cartproduct) {
		long userId = cartproduct.getUserId();
		long prodId = cartproduct.getProdId();
		String sql = "SELECT cartproduct FROM CartProduct cartproduct "
				+ "WHERE cartproduct.userId= :userId AND cartproduct.prodId= :prodId";
		Query query = manager.createQuery(sql);
		query.setParameter("userId", userId);
		query.setParameter("prodId", prodId);
		List<CartProduct> cartproductlist = query.getResultList();
		return cartproductlist;
	}

	@Override
	public int deleteCartProductsByProduct(long prodid, long userid) {
		String sql = "SELECT cartproduct FROM CartProduct cartproduct WHERE cartproduct.prodId = :prodId AND cartproduct.userId = :userId";
		Query query = manager.createQuery(sql);
		query.setParameter("prodId", prodid);
		query.setParameter("userId", userid);
		List<CartProduct> deletedcartprod = query.getResultList();
		manager.remove(deletedcartprod.get(0));
		logger.info("CartProduct deleted successfully = " + deletedcartprod.get(0));
		return 1;
	}

}
