import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
/**
 * Is responsible for directing the data from Time_zone_change to
 * Mailer class and Email class respectively
 * @author Parth Gulati
 *
 */
public class SendMailSSL{    
	/**
	 * Is responsible for taking start_date,start_time,end_date,end_time and location
	 * as parameter from the user and passing it to send and send_to
	 * belonging to Mailer class and Email class respectively 
	 * @param start_date the start date of the meeting
	 * @param start_time the start time of the meeting
	 * @param end_date the end date of the meeting
	 * @param end_time the end time of the meeting 
	 * @param location the location of the meeting
	 */
		 public static void send1(String start_date,String start_time,String end_date,String end_time,String location) {    
		     //calling send function in Mailer class 
		     Mailer.send("<Enter sender's mail>","<Enter password>","<Enter receiver's mail>","Meeting Notification","Good morning sir\nHere are the details for your meeting: \n\n  Date and time :" + start_date + "\n" + start_time + "\n\nPlease be online on the given time and date for the meeting to take place. \n\n Thanks,\nParth");
		     Email.send_to(start_date,start_time,end_date,end_time,location,"<Enter sender's mail>","<Enter password>","<Enter receiver's mail>");
		        
		 }   
}