/**
 * 
 */
package com.oocl.mnlbc.transactions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;

/**
 * @author FLAMEZI2
 *
 */
public class FileTransactions {

   public boolean write(Message message, Session session) {
      try {
         String putData;
         File file = new File(session.getSessionId() + ".txt");
         if (!file.exists()) {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp() + " ClientId: "
               + message.getClientId() + " MessageBody: " + message.getMessage());
            bw.flush();
            bw.close();
         } else {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            putData = "\n" + "Message Id: " + message.getMessageId() + " Timestamp: " + message.getTimestamp()
               + " ClientId: " + message.getClientId() + " MessageBody: " + message.getMessage();
            bw.write(putData);
            bw.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }

   // public static Session generateTestSession(){
   // long id = (long) 0;
   // String timestamp = Timestamp.getTimestamp();
   // List<Client> clientList = new ArrayList<Client>();
   //// message = new Message(0l,0l,0l,"Hello",Timestamp.getTimestamp());
   // return new Session(id,clientList,timestamp);
   // }

}
