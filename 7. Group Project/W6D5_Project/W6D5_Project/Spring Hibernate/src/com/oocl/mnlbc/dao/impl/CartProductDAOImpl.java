package com.oocl.mnlbc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
   public int updateCartProduct(CartProduct cartproduct) {
      CartProduct newCartProduct = manager.find(CartProduct.class, cartproduct.getProdId());
      newCartProduct = cartproduct;
      logger.info("CartProduct updated successfully, cartproduct details=" + newCartProduct);
      return 1;
   }

   @Override
   public int deleteCartProductsByUser(long userid) {
      String sql = "SELECT cartproduct FROM CartProduct cartproduct WHERE cartproduct.userId = " + userid;
      List<CartProduct> cartproductlist = manager.createQuery(sql).getResultList();
      logger.info("User ID = " + userid);
      for (CartProduct cartproduct : cartproductlist) {
         manager.persist(cartproduct);
         logger.info("CartProduct deleted successfully!=" + cartproduct);
      }
      return 1;
   }

   @Override
   public List<CartProduct> getCartProductsByUser(long userid) {
      String sql = "SELECT cartproduct FROM CartProduct cartproduct WHERE cartproduct.userId = " + userid;
      List<CartProduct> cartproductlist = manager.createQuery(sql).getResultList();
      logger.info("User ID = " + userid);
      for (CartProduct cartproduct : cartproductlist) {
         manager.persist(cartproduct);
         logger.info("CartProduct list =" + cartproduct);
      }
      return cartproductlist;
   }

}
