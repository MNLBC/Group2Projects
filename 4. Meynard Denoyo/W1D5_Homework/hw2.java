package com.mnl.app2.w1d5hw;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class hw2 {
   public static void main(String[] args){
      Double rad = 23.0;
      
      Double volume = (4 * Math.PI * rad) / 3;
      DecimalFormat decimalFormat = new DecimalFormat("#,###.0000000000000000");
      
      System.out.println(decimalFormat.format(volume));
   }
}
//(4 * PI * ra3) / 3 