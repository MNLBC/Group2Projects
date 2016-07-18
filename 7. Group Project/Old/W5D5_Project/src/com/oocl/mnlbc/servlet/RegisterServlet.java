package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.dao.UserDAOImpl;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;
import com.oocl.mnlbc.util.PasswordHash;

/**
 * 
 * @author Kassandra Fuentes
 * 
 *         Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;
   private LogUtil logUtil;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public RegisterServlet() {
      super();
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);

   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      UserDAO dao = new UserDAOImpl();

      User user = new User();
      String msg = "failed";
      String userFname = request.getParameter("userFname");
      String userLname = request.getParameter("userLname");
      String userEmail = request.getParameter("userEmail");
      String userStreet = request.getParameter("userStreet");
      String userCity = request.getParameter("userCity");
      String userCountry = request.getParameter("userCountry");
      String userPass = request.getParameter("userPass");
      String userType = request.getParameter("userType");
      String safe = request.getParameter("safe");
      ServletContext sc = this.getServletContext();

      if (safe.equalsIgnoreCase(request.getSession().getAttribute("safecode").toString())) {
         if (userFname != null && userLname != null && userEmail != null && userStreet != null && userCity != null
            && userCountry != null && userPass != null) {
            user.setUserFname(userFname);
            user.setUserLname(userLname);
            user.setUserEmail(userEmail);
            user.setUserStreet(userStreet);
            user.setUserCity(userCity);
            user.setUserCountry(userCountry);
            try {
               userPass = PasswordHash.createHash(userPass);
            } catch (NoSuchAlgorithmException e) {
               LogUtil.logMsg(LogType.ERROR, "Exception: " + e);
            } catch (InvalidKeySpecException e) {
               LogUtil.logMsg(LogType.ERROR, "Exception: " + e);
            }
            user.setUserPass(userPass);
            user.setUserType("Cutomer");
            if (!dao.validateUser(user.getUserEmail())) {
               int result = dao.createUser(user);
               if (result != 0) {
                  msg = "success";
                  LogUtil.logMsg(LogType.INFO, "Create User: " + user);
               }
            }
         }
      }
      response.getWriter().append(msg);
      if (msg == "success") {
         LogUtil.logMsg(LogType.INFO, "Created User!");
         RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp"); // edit here
         rd.forward(request, response);
      } else {
         RequestDispatcher rd = sc.getRequestDispatcher("/Errors.jsp"); // edit here
         rd.forward(request, response);
      }
   }

}
