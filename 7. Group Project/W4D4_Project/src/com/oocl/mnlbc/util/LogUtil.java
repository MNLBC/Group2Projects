package com.oocl.mnlbc.util;

import org.apache.log4j.Logger;

import com.oocl.mnlbc.bean.User;

public class LogUtil {

   final static Logger logger = Logger.getLogger(User.class);

   public void logMsg(LogType type, String msg) {
      switch (type) {
         case DEBUG:
            if (logger.isDebugEnabled()) {
               logger.debug(msg);
            }
            break;
         case INFO:
            if (logger.isInfoEnabled()) {
               logger.info(msg);
            }
            break;
         case WARN:
            logger.warn(msg);
            break;
         case ERROR:
            logger.error(msg);
            break;
         case FATAL:
            logger.fatal(msg);
            break;
      }
   }
}
