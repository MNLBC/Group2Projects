package com.oocl.mnlbc.models;

/**
 * Base Session Class
 * 
 * @author Danna  Group 2
 *
 */
public class Session {

   private Long sessionId;
   private String start;
   private String end;

   public Session(Long sessionId, String start, String end) {
      super();
      this.sessionId = sessionId;
      this.start = start;
      this.end = end;
   }

   public Long getSessionId() {
      return sessionId;
   }

   public void setSessionId(Long sessionId) {
      this.sessionId = sessionId;
   }

   public String getStart() {
      return start;
   }

   public void setStart(String start) {
      this.start = start;
   }

   public String getEnd() {
      return end;
   }

   public void setEnd(String end) {
      this.end = end;
   }

   /**
    * new Session Constructor
    * 
    * @param sessionId
    * @param clientList
    * @param timestamp
    */

}
