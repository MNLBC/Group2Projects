package com.oocl.mnlbc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TIMESTAMP UTIL
 * 
 * @author FLAMEZI2
 * @since 2016-07-08
 */
public class Timestamp {

   /**
    * Get IRIS-4 (OOCL) Timestamp
    * 
    * @return
    */
   public static String getTimestamp() {
      DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
      Calendar calobj = Calendar.getInstance();
      return df.format(calobj.getTime());
   }

}
