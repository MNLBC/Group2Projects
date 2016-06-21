package W1D5Homework;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateSample {
  public static void main(String args[])
{
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd E kk:mm:ss");
     SimpleDateFormat dayFormat = new SimpleDateFormat("E");
     Calendar cal = Calendar.getInstance();
     Date dateToday = cal.getTime();
     String dateFormatted = (String)dateFormat.format(dateToday).toString();
     String getDay = (String)dayFormat.format(dateToday).toString();    

     System.out.println("Date today is:    " + dateFormatted);
     System.out.println("\nAccording to planner: "); 
     switch(checkDay(DayOfWeek.valueOf(getDay)))
     {
        case Mon:
           System.out.println("Attend weekly meeting");
           break;
        case Tue:
           System.out.println("Do resource budgeting");
           break;
        case Wed:
              System.out.println("Conduct research");
              break;
        case Thu:
              System.out.println("Meet with friends");
              break;
        case Fri:
                 System.out.println("Have a night out");
                 break;
        case Sat:
                 System.out.println("Go to gym");
                 break;
        case Sun:
                    System.out.println("Stay at home and rest.");
                    break;    
         default:
                     System.out.println("Stay at home and rest.");
                     break;
     }
}

     public static  DayOfWeek checkDay(DayOfWeek day)
     {
      return day;
        
     }
}
