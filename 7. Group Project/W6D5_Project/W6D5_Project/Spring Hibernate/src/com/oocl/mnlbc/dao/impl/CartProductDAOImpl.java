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
   
   @Override
   public List<CartProduct> checkCartProduct(CartProduct cartproduct) {
      long userid = cartproduct.getUserId();
      long prodid = cartproduct.getProdId();
      String sql = "SELECT cartproduct FROM CartProduct cartproduct "
         + "WHERE cartproduct.userId=" + userid + " AND "
         + "cartproduct.prodId=" + prodid + " ";
      List<CartProduct> cartproductlist = manager.createQuery(sql).getResultList();
      return cartproductlist;
   }

}
