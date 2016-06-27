/**
 * 
 */
package com.oocl.mnlbc.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;

/**
 * File Transactions Class
 * 
 * @author Ziggy
 * @since 2016-06-26
 */
public class FileTransactions {

   public static void main(String[] args) {
      write(generateTestMessage(), generateTestSession());
   }

   /**
    * Write to file
    * 
    * @param message
    * @param session
    * @return boolean
    */
   public static boolean write(Message message, Session session) {
      try {
         String putData = "";
         BufferedWriter bw;
         new File("history").mkdirs();
         File file = new File("history//" + session.getSessionId() + ".log");
         if (!file.exists()) {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write("Timestamp: " + message.getTimestamp() + " ClientId: "
               + message.getClientId() + " MessageBody: " + message.getMessage());
            bw.flush();
         } else {
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            putData = "\n" + "Timestamp: " + message.getTimestamp()
               + " ClientId: " + message.getClientId() + " MessageBody: " + message.getMessage();
            bw.write(putData);
         }
         bw.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }

   /**
    * Gets port from config file
    * 
    * @return String
    */
   public static String getConfigValue(String property) {
      String value = "";
      try {
         // FileReader reader = new FileReader(configFile);
         InputStream stream = FileTransactions.class.getClassLoader().getResourceAsStream("config.properties");
         Properties props = new Properties();
         props.load(stream);
         value = props.getProperty(property);
         stream.close();
         // reader.close();
      } catch (FileNotFoundException ex) {
         System.out.println("File not found");
      } catch (IOException ex) {
         System.out.println("Invalid input");
      }
      return value;

   }

   /**
    * dummy session generator
    * 
    * @return
    */
   public static Session generateTestSession() {
      return new Session(99l, "", "");
   }

   /**
    * dummy message generator
    * 
    * @return Message
    */
   public static Message generateTestMessage() {
      return new Message(99l, 99l, 99l, "Hello World", Timestamp.getTimestamp());
   }

}
