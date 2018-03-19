package communication;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailSender {

   
    private String host;

    private Properties properties;

    private MimeMessage message;
    private BodyPart messageBodyPart;
    private Multipart multipart;

    private Authenticator authenticator;

    public EmailSender () {
        host = "smtp.gmail.com";

        authenticator = new SMTPAuthenticator ();
        properties = System.getProperties ();
        properties.put ( "mail.smtp.host", host );
        properties.put ( "mail.smtp.starttls.enable", "true" );
        properties.put ( "mail.smtp.port", "587" );
        properties.put ( "mail.smtp.auth", "true" );
    }

    public void sendMail (Email email) {
        
    	// Start by reading the .xml file to find the name of the problem, data of submission and administrator 	
    	
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

            messageBodyPart = new MimeBodyPart ();
            DataSource source = new FileDataSource ( email.getFileName() );
            messageBodyPart.setDataHandler ( new DataHandler ( source ) );
            messageBodyPart.setFileName ( email.getFileName() );
            multipart.addBodyPart ( messageBodyPart );

            message.setContent ( multipart );

            Transport.send ( message );
            System.out.println ( "Message send successfully...." );
        } catch ( Exception me ) {
            me.printStackTrace ();
        }
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