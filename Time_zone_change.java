import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar.*;
/**
 * Is responsible for converting the time of local time zone to the time of the
 * time zone of the location which has been passed as parameter to the function
 * and taking care of daylight savings
 * @author Parth Gulati
 *
 */
public class Time_zone_change {
	
	/**
	 * Is responsible for accepting location of the receiver and the date of meeting
	 * as parameters from the file_read() function belonging to the FileRead()
	 * class and converting the time to that of the given time zone of the location
	 * and handling daylight savings issue.
	 * @param location the location of the receiver
	 * @param date1 the date of the meeting to happen
	 */
	public static void time_change(String location, String date1) {
		
			Date datefinal;
		try {   
			  SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss"); //Setting the format for the date        
			  datefinal =sdf.parse(date1);      //Parsing the date from the string input passed
			  Calendar c = Calendar.getInstance();
			  c.setTime(datefinal);
			  System.out.print(c.getTime());
			  TimeZone t = TimeZone.getTimeZone(location);
			  c.setTimeZone(t);
			  c.add(Calendar.MILLISECOND, t.getDSTSavings());
			  System.out.print(c.getTime());
			  SimpleDateFormat sd1 = new SimpleDateFormat("yyyyMMdd");
		      sd1.setTimeZone(TimeZone.getTimeZone(location));
		      SimpleDateFormat sd2 = new SimpleDateFormat("hhmmss");
		      sd2.setTimeZone(TimeZone.getTimeZone(location));
		      
		      String start_date = sd1.format(c.getTime());
		      String start_time = sd2.format(c.getTime());
		      
		      System.out.println(start_time);
		      
		      c.add(Calendar.HOUR_OF_DAY,3); //3 hours meeting
		      
		      String end_date = sd1.format(c.getTime());
		      String end_time = sd2.format(c.getTime());
		      
		      System.out.println("\n" + end_date);
		      System.out.println(end_time);
		      SendMailSSL.send1(start_date,start_time,end_date,end_time,location);
		      	
			
			} catch(ParseException e) {
			  e.printStackTrace();
			  System.out.print("you get the ParseException");
			}
		
	}
}
