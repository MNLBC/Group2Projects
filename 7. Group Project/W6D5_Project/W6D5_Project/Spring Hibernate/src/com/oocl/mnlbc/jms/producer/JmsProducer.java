/**
 * 
 */
package com.oocl.mnlbc.jms.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.oocl.mnlbc.util.Config;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

/**
 * JMS Producer
 * 
 * @author flamezi2
 * @since 2016-07-21
 */
public class JmsProducer {

   private static final String BROKER_URL = Config.getConfigValue("brokerUrl");
   private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
   private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

   /**
    * Send request for user level upgrade
    * 
    * @param username
    */
   public static void sendRequest(String topicType, String username, String message) {
      ConnectionFactory connectionFactory = null;
      Connection connection = null;
      Session session = null;
      Destination destination = null;
      MessageProducer messageProducer = null;

      connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
      try {
         connection = connectionFactory.createConnection();
         connection.start();
         session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
         destination = session.createTopic(Config.getConfigValue(topicType));
         messageProducer = session.createProducer(destination);
         Message textMessage = session.createTextMessage(username);
         if (topicType != "adminTopic") {
            textMessage = session.createTextMessage(message);
         }
         messageProducer.send(textMessage);
         session.commit();
      } catch (JMSException e) {
         LogUtil.logMsg(LogType.ERROR, "Error: JMSException" + e);
      }
   }

}
