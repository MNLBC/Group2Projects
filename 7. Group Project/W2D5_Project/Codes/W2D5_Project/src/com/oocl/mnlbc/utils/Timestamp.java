package com.oocl.mnlbc.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Timestamp util class
 * @author FLAMEZI2
 * 
 */
public class Timestamp {

   /**
    * get Timestamp
    * @return
    */
   public String getTimestamp(){
      DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
      Calendar calobj = Calendar.getInstance();
      return df.format(calobj.getTime());
   }
}
