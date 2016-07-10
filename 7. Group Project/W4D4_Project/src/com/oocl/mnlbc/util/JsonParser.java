package com.oocl.mnlbc.util;

import java.util.List;

import com.google.gson.Gson;
import com.oocl.mnlbc.bean.Order;
import com.oocl.mnlbc.bean.OrderProduct;
import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.bean.User;

/**
 * JSON PARSER UTIL
 * 
 * @author FLAMEZI2
 * @since 2016-07-08
 */
public class JsonParser {

   /**
    * parse User to Json
    * 
    * @param user
    * @return
    */
   public static String toUserJson(User user) {
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
   public static String toProductJson(Product prod) {
      Gson gson = new Gson();
      String json = gson.toJson(prod);
      return json;
   }

   /**
    * parse ProductList to Json
    * 
    * @param prod
    * @return
    */
   public static String toProductJson(List<Product> prodList) {
      Gson gson = new Gson();
      String json = gson.toJson(prodList);
      return json;
   }

   /**
    * parse Order to Json
    * 
    * @param order
    * @return
    */
   public static String toOrderJson(Order order) {
      Gson gson = new Gson();
      String json = gson.toJson(order);
      return json;
   }

   /**
    * parse OrderProduct to Json
    * 
    * @param orderprod
    * @return
    */
   public static String toOrderProductJson(OrderProduct orderprod) {
      Gson gson = new Gson();
      String json = gson.toJson(orderprod);
      return json;
   }

   /**
    * parse Json to User
    * 
    * @param str
    * @return
    */
   public static User toUserObject(String str) {
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
   public static Product toProductObject(String str) {
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
   public static Order toOrderObject(String str) {
      Gson gson = new Gson();
      Order order = gson.fromJson(str, Order.class);
      return order;
   }

   /**
    * parse Json to OrderProduct
    * 
    * @param str
    * @return
    */
   public static OrderProduct toOrderProductObject(String str) {
      Gson gson = new Gson();
      OrderProduct orderprod = gson.fromJson(str, OrderProduct.class);
      return orderprod;
   }
}
