import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    

/**
 * Is responsible for establishing connection to the server
 * and sending the email to the intended receiver
 * @author Parth Gulati
 *
 */	
	public class Mailer{  
			/**
			 * Is responsible for taking from,password,to,sub and message
			 * as parameters from SendMailSSL.send1(), setting up 
			 * connection to the server, password authentication 
			 * of Email ID and sending email to the intended user
			 * @param from Email ID of the sender
			 * @param password Password of the sender's email ID
			 * @param to Email ID of the receiver
			 * @param sub Subject of the Email
			 * @param msg The message which has to be sent
			 */
		    public static void send(String from,String password,String to,String sub,String msg){  
		          //Get properties object    
		          Properties props = new Properties();    
		          props.put("mail.smtp.host", "smtp.gmail.com");    
		          props.put("mail.smtp.socketFactory.port", "465");    
		          props.put("mail.smtp.socketFactory.class",    
		                    "javax.net.ssl.SSLSocketFactory");    
		          props.put("mail.smtp.auth", "true");    
		          props.put("mail.smtp.port", "465");    
		          //get Session   
		          Session session = Session.getDefaultInstance(props,    
		           new javax.mail.Authenticator() {    
		           protected PasswordAuthentication getPasswordAuthentication() {    
		           return new PasswordAuthentication(from,password);  
		           }    
		          });    
		          //compose message    
		          try {    
		           MimeMessage message = new MimeMessage(session);    
		           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
		           message.setSubject(sub);    
		           message.setText(msg);    
		           //send message  
		           Transport.send(message);    
		           System.out.println("message sent successfully");    
		          } catch (MessagingException e) {throw new RuntimeException(e);}    
		             
		    }  
		}  
		 
