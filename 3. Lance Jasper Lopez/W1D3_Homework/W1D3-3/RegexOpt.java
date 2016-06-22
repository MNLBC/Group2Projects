import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexOpt {
	public static boolean isEmail(String email){
		boolean validMail = true;
		Pattern emailPattern =  Pattern
				.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Matcher matcher = emailPattern .matcher(email);
	     
		 validMail = matcher.find();
		
		return validMail; 
				
	}
	
	public static boolean isMobileNum(String mobNum){
		boolean validMobileNum = true;
		Pattern mobileNumPattern =
				Pattern.compile("^[+][1-9]{1}[0-9]{3,14}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = mobileNumPattern.matcher(mobNum);
		validMobileNum = matcher.find();
		return validMobileNum;
	
	}
	
	public static String replaceCharWithA(String input){
		String newStr = "";
		newStr = input.replace('a', 'A');
		return newStr;
	}
	
	public static String getMonthFromDate(String date) {
		String month = "";
		String text = "Sep 25, 2013 4:51:00 PM";
		try{
		Date convertDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(date);
		
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		month = monthFormat.format(convertDate).toString();
		
		}
		catch(ParseException e){
			System.out.println("Wrong format");
		}
		return month;
	}
	
}
