package com.oocl.mnlbc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timestamp {

	public static String getTimestamp() {
		      DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
		      Calendar calobj = Calendar.getInstance();
		      return df.format(calobj.getTime());
	}
		   
}
