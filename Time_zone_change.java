import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;

public class Time_zone_change {
	
	public static void time_change(String location, String date1) {
		
			Date datefinal;
		try {   
			  SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss"); //Setting the format for the date        
			  datefinal =sdf.parse(date1);      //Parsing the date from the string input passed
			  SimpleDateFormat sdc= new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
			  
			  TimeZone obj = TimeZone.getTimeZone(location); //Passing a sample timezone (Central Standard Time)
			  sdc.setTimeZone(obj);
			  String fdate=sdc.format(datefinal);
			  System.out.println(fdate);
			  SendMailSSL.send1(fdate);
			 
			} catch(ParseException e) {
			  e.printStackTrace();
			  System.out.print("you get the ParseException");
			}
		
	}
}
