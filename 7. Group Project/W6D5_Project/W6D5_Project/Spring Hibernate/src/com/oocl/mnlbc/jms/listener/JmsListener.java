package com.oocl.mnlbc.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.oocl.mnlbc.model.Request;
import com.oocl.mnlbc.svc.inf.OrderProductSVC;
import com.oocl.mnlbc.svc.inf.RequestSVC;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;
import com.oocl.mnlbc.util.Timestamp;

/**
 * JMS Listener
 * 
 * @author flamezi2
 * @since 2016-07-21
 */
public class JmsListener implements MessageListener {

   private RequestSVC requestSVC;

   @Autowired(required = true)
   @Qualifier(value = "requestService")
   public void setOrderProdService(RequestSVC requestSVC) {
      this.requestSVC = requestSVC;
   }
   
   public void onMessage(Message message) {
      if (message != null && message instanceof TextMessage) {
         try {
            TextMessage textMessage = (TextMessage) message;
            LogUtil.logMsg(LogType.INFO, textMessage.getText());
            LogUtil.logMsg(LogType.INFO, message.getJMSDestination().toString());
            this.requestSVC.createRequest(textMessage.getText());
         } catch (JMSException e) {
            e.printStackTrace();
         }
      }
   }

}
