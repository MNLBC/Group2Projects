package com.oocl.mnlbc.models;

/**
 * Base Message Class
 * @author FLAMEZI2 Group 2
 *
 */
public class Message {

   private Long sessionId;
   private Long messageId;
   private String message;
   private String timestamp;

   /**
    * new Message constructor
    * @param sessionId
    * @param messageId
    * @param message
    * @param timestamp
    */
   public Message(Long sessionId, Long messageId, String message, String timestamp) {
      super();
      this.sessionId = sessionId;
      this.messageId = messageId;
      this.message = message;
      this.timestamp = timestamp;
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
