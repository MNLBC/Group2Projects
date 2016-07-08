package com.oocl.mnlbc.util;

import com.google.gson.Gson;
import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.bean.User;

/**
 * 
 * @author FLAMEZI2
 * @since 2016-07-08 JSON PARSER UTIL
 */
public class JsonParser {

   /**
    * parse User to Json
    * 
    * @param user
    * @return
    */
   public String toUserJson(User user) {
      Gson gson = new Gson();
      String json = gson.toJson(user);
      return json;
   }

   /**
    * parse Product to Json
    * 
    * @param prod
    * @return
    */
   public String toProductJson(Product prod) {
      Gson gson = new Gson();
      String json = gson.toJson(prod);
      return json;
   }

   /**
    * parse Order to Json
    * 
    * @param order
    * @return
    */
   public String toOrderJson(Order order) {
      Gson gson = new Gson();
      String json = gson.toJson(order);
      return json;
   }

   /**
    * parse Json to User
    * 
    * @param str
    * @return
    */
   public User toUserObject(String str) {
      Gson gson = new Gson();
      User user = gson.fromJson(str, User.class);
      return user;
   }

   /**
    * parse Json to Product
    * 
    * @param str
    * @return
    */
   public Product toProductObject(String str) {
      Gson gson = new Gson();
      Product prod = gson.fromJson(str, Product.class);
      return prod;
   }

   /**
    * parse Json to Order
    * 
    * @param str
    * @return
    */
   public Order toOrderObject(String str) {
      Gson gson = new Gson();
      Order order = gson.fromJson(str, Order.class);
      return order;
   }
}
