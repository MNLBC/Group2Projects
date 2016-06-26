package com.oocl.mnlbc.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Timestamp util class
 * 
 * @author FLAMEZI2
 * @date 2016-06-26
 */
public class Timestamp {

   /**
    * get Timestamp
    * 
    * @return
    */
   public static String getTimestamp() {
      DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
      Calendar calobj = Calendar.getInstance();
      return df.format(calobj.getTime());
   }
}
