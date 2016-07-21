/**
 * 
 */
package com.oocl.mnlbc.controller;

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
   public int sendAdminMessage(@RequestParam("username") String username) {
      try {
         JmsProducer.sendRequest("adminTopic", username);
         return 1;
      } catch (Exception e) {
         LogUtil.logMsg(LogType.ERROR, "Error: " + e);
         return 0;
      }
   }
}
