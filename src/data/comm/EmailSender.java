package data.comm;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import utilities.ConsoleLogger;
import utilities.Paths;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailSender {

   
    private String host;

    private Properties properties;

    private MimeMessage message;
    private BodyPart messageBodyPart;
    private Multipart multipart;

    private Authenticator authenticator;
    
    private ConsoleLogger logger;

    public EmailSender () {
        host = "smtp.gmail.com";

        authenticator = new SMTPAuthenticator ();
        properties = System.getProperties ();
        properties.put ( "mail.smtp.host", host );
        properties.put ( "mail.smtp.starttls.enable", "true" );
        properties.put ( "mail.smtp.port", "587" );
        properties.put ( "mail.smtp.auth", "true" );
        logger = new ConsoleLogger("EMAIL-SENDER");
    }

    public void sendMail (Email email) {
    	try {
            Session session = Session.getDefaultInstance ( properties, authenticator );
            message = new MimeMessage ( session );
            message.setFrom ( new InternetAddress ( email.getFrom() ) );
            message.addRecipient ( Message.RecipientType.TO,
                                new InternetAddress ( email.getTo() ) );
            message.addRecipient ( Message.RecipientType.CC,
                    new InternetAddress ( email.getAdmin() ) );
                        
            message.setSubject ( email.getSubject() );
            multipart = new MimeMultipart ();
            
            messageBodyPart = new MimeBodyPart ();
            messageBodyPart.setContent (email.getMessageBody(), "text/html" );
            multipart.addBodyPart ( messageBodyPart );
        
            if (email.getCurrentType() == 2 || email.getCurrentType() == 4) {
            	messageBodyPart = new MimeBodyPart ();
            	DataSource source = new FileDataSource (Paths.RESULTS_FOLDER + email.getProblemName()
            		+ "/" + email.getProblemName() + "_solutions.json");
            	messageBodyPart.setDataHandler ( new DataHandler ( source ) );
            	messageBodyPart.setFileName (email.getProblemName() + "_solutions.json");
            	multipart.addBodyPart ( messageBodyPart );
            }

            message.setContent ( multipart );

            Transport.send ( message );
            logger.writeConsoleLog("Message of type " + email.getCurrentType() + " sent to " + email.getTo() + ".");
        } catch ( Exception me ) {
            me.printStackTrace ();
        }
    }

	public String getHost() {
		return host;
	}

	public Properties getProperties() {
		return properties;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	} 

}

/**
  * SimpleAuthenticator is used to do simple authentication
  * when the SMTP server requires it.
  */

class SMTPAuthenticator extends Authenticator {

    private static final String SMTP_AUTH_USER = "geral.nemesis@gmail.com";
    private static final String SMTP_AUTH_PASSWORD = "nemesis2018";

    public PasswordAuthentication getPasswordAuthentication () {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PASSWORD;

        return new PasswordAuthentication( username,  password );
    }
}