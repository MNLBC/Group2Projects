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
public class JmsUserController {

   @RequestMapping("/runUserConsumer")
   public int runUserConsumer() {
      try {
         JmsConsumer.startConsumer("userTopic");
         return 1;
      } catch (Exception e) {
         LogUtil.logMsg(LogType.ERROR, "Error: " + e);
         return 0;
      }
   }

   @RequestMapping("/sendUserMessage")
   public int sendUserMessage(@RequestParam("username") String username, @RequestParam("message") String message) {
      try {
         JmsProducer.sendRequest("userTopic", username, message);
         return 1;
      } catch (Exception e) {
         LogUtil.logMsg(LogType.ERROR, "Error: " + e);
         return 0;
      }
   }
}
