package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.bean.Product;
import com.oocl.mnlbc.util.DbConnection;

public class ProductDAOImpl implements ProductDAO {

   DbConnection dbConnect = new DbConnection();

   @Override
   public List<Product> getProducts() {
      List<Product> result = new ArrayList<Product>();
      Connection conn = dbConnect.getConn();

      String sql = "SELECT * FROM PRODUCT";

      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         ResultSet rs = pStmt.executeQuery();
         while (rs.next()) {
            if (!(rs.getString("PRODID") == null)) {
               Product prod = new Product();
               prod.setProdId(rs.getLong("PRODID"));
               prod.setProdName("PRODNAME");
               prod.setProdCat("PRODCAT");
               prod.setProdPrice(Double.parseDouble(rs.getString("PRODPRICE")));
               prod.setProdStock(Integer.parseInt(rs.getString("PRODSTOCK")));
               prod.setProdImg(rs.getString("PRODIMG"));
               prod.setProdSale(Double.parseDouble(rs.getString("PRODSALE")));
               result.add(prod);
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   @Override
   public int updateStock(Product product, int qty) {
      int result = 0;
      Connection conn = dbConnect.getConn();
      String sql = "UPDATE PRODUCT SET PRODSTOCK = PRODSTOCK - ? WHERE PRODID = ?";

      PreparedStatement pStmt;
      try {
         pStmt = (PreparedStatement) conn.prepareStatement(sql);
         pStmt.setInt(1, qty);
         pStmt.setLong(2, product.getProdId());
         result = pStmt.executeUpdate();
         pStmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;
   }

}
