package communication;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public final class EmailSender {

    private static String from;
    private static String to;
    private static String subject;
    private static String messageBody;
    private static String fileName;
    private static String host;

    private static Properties properties;

    private static MimeMessage message;
    private static BodyPart messageBodyPart;
    private static Multipart multipart;

    private static Authenticator authenticator;

    private EmailSender () {
        from = "geral.nemesis@gmail.com";
        /*to = "rodolfo.afa@gmail.com";
        subject = "Subject Testing";
        messageBody = "<html><body><h1>HAVE FAITH, AND STAY" +
                    " CALM :-) I AM WITH YOU, OKAY :-)</h1></body></html>";
        fileName = "quiz.txt";*/
        host = "smtp.gmail.com";

        authenticator = new SMTPAuthenticator ();
        properties = System.getProperties ();
        properties.put ( "mail.smtp.host", host );
        properties.put ( "mail.smtp.starttls.enable", "true" );
        properties.put ( "mail.smtp.port", "587" );
        properties.put ( "mail.smtp.auth", "true" );
    }

    public static void sendMail ( String from, String to,
                    String subject, String messageBody, String fileName ) {
        try {
            Session session = Session.getDefaultInstance ( properties, authenticator );
            message = new MimeMessage ( session );
            message.setFrom ( new InternetAddress ( from ) );
            message.addRecipient ( Message.RecipientType.TO,
                                new InternetAddress ( to ) );
            message.setSubject ( subject );

            multipart = new MimeMultipart ();
            messageBodyPart = new MimeBodyPart ();
            messageBodyPart.setContent ( messageBody, "text/html" );
            multipart.addBodyPart ( messageBodyPart );

            messageBodyPart = new MimeBodyPart ();
            DataSource source = new FileDataSource ( fileName );
            messageBodyPart.setDataHandler ( new DataHandler ( source ) );
            messageBodyPart.setFileName ( fileName );
            multipart.addBodyPart ( messageBodyPart );

            message.setContent ( multipart );

            Transport.send ( message );
            System.out.println ( "Message send successfully...." );
        } catch ( Exception me ) {
            me.printStackTrace ();
        }
    } 

    /*private void performTask () {
        sendMail ( from, to, subject, messageBody, fileName );
    }

    public static void main ( String[] args ) {
        new EmailSender ().performTask ();
    }*/
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