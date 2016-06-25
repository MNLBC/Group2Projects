/**
 * 
 */
package com.oocl.mnlbc.transactions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.Timestamp;

/**
 * @author FLAMEZI2
 *
 */
public class FileTransactions {

   public static void main(String[] args) {
      write(generateTestMessage(), generateTestSession());
   }

   public static boolean write(Message message, Session session) {
      try {
         String putData = "";
         BufferedWriter bw;
         File file = new File("history//" + session.getSessionId() + ".log");
         if (!file.exists()) {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write("Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp() + " ClientId: "
               + message.getClientId() + " MessageBody: " + message.getMessage());
         } else {
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            putData = "\n" + "Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp()
               + " ClientId: " + message.getClientId() + " MessageBody: " + message.getMessage();
            bw.write(putData);
         }
         bw.flush();
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }

   public static String getPort() {
      File configFile = new File("config//config.properties");
      String port = "";

      try {
         FileReader reader = new FileReader(configFile);
         Properties props = new Properties();
         props.load(reader);
         port = props.getProperty("port");
         reader.close();
      } catch (FileNotFoundException ex) {
         System.out.println("File not found");
      } catch (IOException ex) {
         System.out.println("Invalid input");
      }
      return port;

   }

   public static Session generateTestSession() {
      return new Session(0l, "", "");
   }

   public static Message generateTestMessage() {
      return new Message(0l, 0l, 0l, "Hello World", Timestamp.getTimestamp());
   }

}
