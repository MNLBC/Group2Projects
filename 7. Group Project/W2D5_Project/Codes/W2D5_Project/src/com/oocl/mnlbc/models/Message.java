package com.oocl.mnlbc.models;

/**
 * Base Message Class
 * 
 * @author Ziggy Group 2
 * @since 2016-06-26
 */
public class Message {

   private Long sessionId;
   private Long messageId;
   private Long clientId;
   private String message;
   private String timestamp;

   /**
    * new Message constructor
    * 
    * @param sessionId
    * @param messageId
    * @param clientId
    * @param message
    * @param timestamp
    */
   public Message(Long sessionId, Long messageId, Long clientId, String message, String timestamp) {
      super();
      this.sessionId = sessionId;
      this.messageId = messageId;
      this.clientId = clientId;
      this.message = message;
      this.timestamp = timestamp;
   }

   public Long getClientId() {
      return clientId;
   }

   public void setClientId(Long clientId) {
      this.clientId = clientId;
   }

   public Long getSessionId() {
      return sessionId;
   }

   public void setSessionId(Long sessionId) {
      this.sessionId = sessionId;
   }

   public Long getMessageId() {
      return messageId;
   }

   public void setMessageId(Long messageId) {
      this.messageId = messageId;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
   }

}
