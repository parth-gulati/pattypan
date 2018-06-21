import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
public class SendMailSSL{    
		 public static void send1(String fdate) {    
		     //calling send function in Mailer class 
		     Mailer.send("<enter sender's email id>","<password>","<enter receiver's email id>","Meeting Notification","Good morning sir\nHere are the details for your meeting: \n\n  Date and time :" + fdate + "\n\nPlease be online on the given time and date for the meeting to take place. \n\n Thanks,\nParth");  
		        
		 }   
}
