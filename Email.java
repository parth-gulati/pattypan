import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;





/**
 * The class is responsible for sending the e-invite to the intended recievers
 * @author Parth Gulati
 *
 */
public class Email {

	/**Default constructor, which constructs
	 * the email class.
	 */
    public Email() {
    }

    /**
     * It creates an instance of the class Email and calls the function send() by 
     * passing the details of the meeting as argument to the function
     * @param start_date The start date of the meeting
     * @param start_time The start time of the meeting
     * @param end_date The end date of the meeting
     * @param end_time The end time of the meeting
     * @param location The location of the reciever of the e-invite
     */
    public static void send_to(String start_date,String start_time,String end_date,String end_time,String location,String from,String password,String to) {
    	
    	
    	Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
           
        
        try {
            Email email = new Email();
            email.send(start_date,start_time,end_date,end_time,location,from,password,to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * It takes start_date,start_time,end_date,end_time,location,from,
     * password and to as parameter from SendMailSSL.send1(), sets up
     * the connection between the server and the user, is responsible for
     * password authentication from the server and it sends 
     * the meeting invite to the given guests
     * @param start_date the start date of the meeting
     * @param start_time the start time of the meeting
     * @param end_date the end date of the meeting
     * @param end_time the end time of the meeting
     * @param location the location of the reciever of the e-invite
     * @throws Exception if the establishment of connection to the server is unsuccessful
     */
    public void send(String start_date,String start_time,String end_date,String end_time,String location,String from,String password,String to) throws Exception {

        try {
            String to2 = "parth.gulati@outlook.com";
            Properties props = new Properties();
            props.put("mail.smtp.host", "mailhost");

            Session session = Session.getDefaultInstance(props,    
                    new javax.mail.Authenticator() {    
                    protected PasswordAuthentication getPasswordAuthentication() {    
                    return new PasswordAuthentication(from,password);  
                    }    
                   });
            MimeMessage message = new MimeMessage(session);
            message.addHeaderLine("method=REQUEST");
            message.addHeaderLine("charset=UTF-8");
            message.addHeaderLine("component=VEVENT");

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to2));
            message.setSubject("Outlook Meeting Request Using JavaMail");

            StringBuffer sb = new StringBuffer();

            StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
                    "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
                    "VERSION:2.0\n" +
                    "METHOD:REQUEST\n" +
                    "BEGIN:VEVENT\n" +
                    "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:gulati.parth98@gmail.com\n" +
                    "ORGANIZER:MAILTO:gulati.parth98@gmail.com.com\n" +
                    "DTSTART:"+start_date+"T"+start_time+"\n"+
                    "DTEND:"+end_date+"T"+end_time+"\n" +
                    "LOCATION:"+location+"\n" +
                    "TRANSP:OPAQUE\n" +
                    "SEQUENCE:0\n" +
                    "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n" +
                    " 000004377FE5C37984842BF9440448399EB02\n" +
                    "DTSTAMP:20051206T120102Z\n" +
                    "CATEGORIES:Meeting\n" +
                    "DESCRIPTION:Kindly RSVP ASAP.\n\n" +
                    "SUMMARY:Online meeting request\n" +
                    "PRIORITY:5\n" +
                    "CLASS:PUBLIC\n" +
                    "BEGIN:VALARM\n" +
                    "TRIGGER:PT1440M\n" +
                    "ACTION:DISPLAY\n" +
                    "DESCRIPTION:Reminder\n" +
                    "END:VALARM\n" +
                    "END:VEVENT\n" +
                    "END:VCALENDAR");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
            messageBodyPart.setHeader("Content-ID", "calendar_message");
            messageBodyPart.setDataHandler(new DataHandler(
                    new ByteArrayDataSource(buffer.toString(), "text/calendar")));// very important

            // Create a Multipart
            Multipart multipart = new MimeMultipart();

            // Add part one
            multipart.addBodyPart(messageBodyPart);

            // Put parts in message
            message.setContent(multipart);

            // send message
            Transport.send(message);
            
            //display if sent successfully
            
            System.out.println("Email invite sent successfully");
            
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}