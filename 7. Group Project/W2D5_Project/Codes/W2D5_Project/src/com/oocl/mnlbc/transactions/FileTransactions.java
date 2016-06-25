/**
 * 
 */
package com.oocl.mnlbc.transactions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * @author FLAMEZI2 File Transactions Class 2016-06-26
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
            bw.write("Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp() + " ClientId: "
               + message.getClientId() + " MessageBody: " + message.getMessage());
            bw.flush();
         } else {
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            putData = "\n" + "Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp()
               + " ClientId: " + message.getClientId() + " MessageBody: " + message.getMessage();
            bw.write(putData);
         }
         bw.close();
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
   public static String getPort() {
      String port = "";
      try {
         // FileReader reader = new FileReader(configFile);
         InputStream stream = FileTransactions.class.getClassLoader().getResourceAsStream("config.properties");
         Properties props = new Properties();
         props.load(stream);
         port = props.getProperty("port");
         stream.close();
         // reader.close();
      } catch (FileNotFoundException ex) {
         System.out.println("File not found");
      } catch (IOException ex) {
         System.out.println("Invalid input");
      }
      return port;

   }

   /**
    * dummy session generator
    * 
    * @return
    */
   public static Session generateTestSession() {
      return new Session(0l, "", "");
   }

   /**
    * dummy message generator
    * 
    * @return Message
    */
   public static Message generateTestMessage() {
      return new Message(0l, 0l, 0l, "Hello World", Timestamp.getTimestamp());
   }

}
