/**
 * 
 */
package com.oocl.mnlbc.jms.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.oocl.mnlbc.jms.listener.JmsListener;
import com.oocl.mnlbc.util.Config;

/**
 * JMS Consumer
 * 
 * @author flamezi2
 * @since 2016-07-21
 */
public class JmsConsumer {

   private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
   private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
   private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

   /**
    * Starts admin consumer
    */
   public static void startConsumer() {
      ConnectionFactory connectionFactory = null;
      Connection connection = null;
      Session session = null;
      Destination destination = null;

      MessageConsumer messageConsumer = null;

      connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
      try {
         connection = connectionFactory.createConnection();
         connection.start();
         session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
         destination = session.createTopic(Config.getConfigValue("adminTopic"));
         messageConsumer = session.createConsumer(destination);
         messageConsumer.setMessageListener(new JmsListener());
         session.commit();
      } catch (JMSException e) {
         e.printStackTrace();
      }
   }
}
