package com.oocl.mnlbc.models;

import java.util.List;

/**
 * Base Session Class
 * @author FLAMEZI2 Group 2
 *
 */
public class Session {

   private Long sessionId;
   private List<Client> clientList;
   private String timestamp;

   /**
    * new Session Constructor
    * @param sessionId
    * @param clientList
    * @param timestamp
    */
   public Session(Long sessionId, List<Client> clientList, String timestamp) {
      super();
      this.sessionId = sessionId;
      this.clientList = clientList;
      this.timestamp = timestamp;
   }

   public Long getSessionId() {
      return sessionId;
   }

   public void setSessionId(Long sessionId) {
      this.sessionId = sessionId;
   }

   public List<Client> getClientList() {
      return clientList;
   }

   public void setClientList(List<Client> clientList) {
      this.clientList = clientList;
   }

   public String getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
   }

}
