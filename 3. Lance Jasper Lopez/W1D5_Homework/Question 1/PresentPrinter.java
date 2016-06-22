import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author lopezla
 * 
 */

// Answer for #1 in W1D5 Homework

public class PresentPrinter {

	public static void main(String[] args) {

		String pattern = "yyyy.mm.dd EEE HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);

		SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
		String day = dayFormat.format(new Date());
		System.out.println("Activity for today:");
		if (day.equals("Sun")) {
			System.out.println("No appointment is made");
		} else if (day.equals("Mon")) {
			System.out.println("No appointment is made");
		} else if (day.equals("Tue")) {
			System.out.println("No appointment is made");
		}

		else if (day.equals("Wed")) {
			System.out.println("No appointment is made");
		}

		else if (day.equals("Thur")) {
			System.out.println("No appointment is made");
		}

		else if (day.equals("Fri")) {
			System.out.println("Do Household Chores");
		}

		else if (day.equals("Sat")) {
			System.out.println("No appointment is made");
		}

	}
}
