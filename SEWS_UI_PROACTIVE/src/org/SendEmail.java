package org;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendEmail
{
	public SendEmail()
	{
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa");
	}
    private class SMTPAuthenticator extends Authenticator
    {
        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password)
        {
             authentication = new PasswordAuthentication(login, password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
             return authentication;
        }
    }

    public void mail(String temp,HashMap<String,String> hm)
    {
        System.out.println("!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@!@");
            String from = "parmesh20120@gmail.com";
            String to = "parmesh20120@gmail.com";
            String subject = "SEWS Alert.";
           StringTokenizer tokn=new StringTokenizer(temp,"*");
            String message1 = tokn.nextToken();
            String message2=tokn.nextToken();
            String message3="";
            try
    		{
    			Set set = hm.entrySet();
    			Iterator i = set.iterator();
    		      // Display elements
    			
    			
    		      while(i.hasNext()) {
    		    	 
    		    	  Map.Entry me = (Map.Entry)i.next();
    		    	  message3+=(String)me.getKey()+",";
    		    	 
    		    	  
    		    	 
    		                  
    		      }
    		      System.out.println("QA"+message3);
    		}
            catch(Exception e)
            {
            	
            }
           
            String login = "parmesh20120@gmail.com";
            String password = "IsamsAZAD";

            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");

            Authenticator auth = new SMTPAuthenticator(login, password);

            Session session = Session.getInstance(props, auth);

            MimeMessage msg = new MimeMessage(session);

           try
           {
        	   msg.setContent("<p align='center'><font size='25' color='#FF0000'>Alert</font> </p>"+ "<p align='left'><font size='8' color='#660000'>"+"Error:  "+message1+"</font> </p>" + "<h5>"+message2+"</h5>" +"<h4><b>"+message3+"</b></h4>" , "text/html" );
                msg.setSubject(subject);
                msg.setFrom(new InternetAddress(from));
                msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
                Transport.send(msg);
           }
           catch (MessagingException ex)
           {
        	   System.out.println("###############################");
                Logger.getLogger(SendEmail.class.getName()).
                log(Level.SEVERE, null, ex);
           }
      
    }
    public static void main(String arg[])
    {
  	 
    }
    
}

