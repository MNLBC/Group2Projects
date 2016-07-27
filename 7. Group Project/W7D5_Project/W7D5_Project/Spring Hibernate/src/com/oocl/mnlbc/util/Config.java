/**
 * 
 */
package com.oocl.mnlbc.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Config Class
 * 
 * @author Ziggy
 * @since 2016-07-21
 */
public class Config {

   /**
    * Gets value from config file
    * 
    * @return String
    */
   public static String getConfigValue(String property) {
      String value = "";
      try {
         // FileReader reader = new FileReader(configFile);
         InputStream stream = Config.class.getClassLoader().getResourceAsStream("config.properties");
         Properties props = new Properties();
         props.load(stream);
         value = props.getProperty(property);
         stream.close();
         // reader.close();
      } catch (FileNotFoundException ex) {
         LogUtil.logMsg(LogType.ERROR, "Error: File not found");
      } catch (IOException ex) {
         LogUtil.logMsg(LogType.ERROR, "Error: Invalid input");
      }
      return value;

   }
}
