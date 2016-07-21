package com.oocl.mnlbc.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

/**
 * JMS Listener
 * 
 * @author flamezi2
 * @since 2016-07-21
 */
public class JmsListener implements MessageListener {

   public void onMessage(Message message) {
      if (message != null && message instanceof TextMessage) {
         try {
            TextMessage textMessage = (TextMessage) message;
            LogUtil.logMsg(LogType.INFO, textMessage.getText());
         } catch (JMSException e) {
            e.printStackTrace();
         }
      }
   }

}
