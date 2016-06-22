package homeworkW1D5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class App1 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
      DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
      Calendar cal = Calendar.getInstance();
      int day = cal.get(cal.DAY_OF_WEEK);
      String action = "";
      System.out.print(dateFormat.format(cal.getTime()) + " ");
      switch(day){
         case 1:
            System.out.print("Sun ");
            action = "Rest today";
            break;
         case 2:
            System.out.print("Mon ");
            action = "Get ready for first day of work";
            break;
         case 3:
            System.out.print("Tue ");
            action = "Meeting with boss";
            break;
         case 4:
            System.out.print("Wed ");
            action = "Visit family for dinner";
            break;
         case 5:
            System.out.print("Thu ");
            action = "No important appointment";
            break;
         case 6:
            System.out.print("Fri ");
            action = "Go out with bae";
            break;
         case 7:
            System.out.print("Sat ");
            action = "Watch TV";
            break;
      }
      System.out.println(timeFormat.format(cal.getTime()));
      System.out.println(action);
   }

}
