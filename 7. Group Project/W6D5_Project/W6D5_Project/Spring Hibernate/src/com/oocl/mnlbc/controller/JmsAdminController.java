/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.jms.consumer.JmsConsumer;
import com.oocl.mnlbc.jms.producer.JmsProducer;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

/**
 * JMS Admin Controller
 * 
 * @author FLAMEZI2
 * @since 2016-07-21
 */
@RestController
public class JmsAdminController {

   @RequestMapping("/runAdminConsumer")
   public int runAdminConsumer() {
      try {
         JmsConsumer.startConsumer("adminTopic");
         return 1;
      } catch (Exception e) {
         LogUtil.logMsg(LogType.ERROR, "Error: " + e);
         return 0;
      }
   }

   @RequestMapping("/sendAdminMessage")
   public int sendAdminMessage(@RequestParam("username") String username, @RequestParam("message") String message,
      HttpServletRequest request) {
      try {
         JmsProducer.sendRequest("adminTopic", username, message);
         return 1;
      } catch (Exception e) {
         LogUtil.logMsg(LogType.ERROR, "Error: " + e);
         return 0;
      }
   }

   @SuppressWarnings("unchecked")
   @RequestMapping("/getAllMessages")
   public List<String> getAllMessages(HttpServletRequest request) {
      List<String> requestList = (List<String>) request.getServletContext().getAttribute("requestList");
      LogUtil.logMsg(LogType.INFO, "Number of Requests: " + requestList.size());
      return requestList;
   }

   @SuppressWarnings("unchecked")
   @RequestMapping("/addMessage")
   public Boolean addMessage(@RequestParam("message") String message, HttpServletRequest request) {
      List<String> requestList = (List<String>) request.getServletContext().getAttribute("requestList");
      if (requestList == null) {
         requestList = new ArrayList<String>();
      }
      requestList.add(message);
      request.getServletContext().setAttribute("requestList", requestList);
      LogUtil.logMsg(LogType.INFO, "Requesting User: " + message);
      LogUtil.logMsg(LogType.INFO, "Number of Requests: " + requestList.size());
      return true;
   }
}
