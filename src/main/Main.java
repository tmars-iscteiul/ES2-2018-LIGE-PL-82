package main;

import communication.Email;
import communication.EmailSender;

public class Main {

	public static void main(String[] args) {
		Email email1 = new Email();
		email1.success_email("tmars@iscte-iul.pt");
		
		EmailSender emailsender = new EmailSender();
		emailsender.sendMail(email1);
		
		email1.fail_email("tmars@iscte-iul.pt");
		emailsender.sendMail(email1);
		
		email1.progression_email("tmars@iscte-iul.pt", 75.0);
		emailsender.sendMail(email1);
		
		email1.welcome_email("tmars@iscte-iul.pt");
		emailsender.sendMail(email1);
		
		Engine engine = new Engine();
		engine.load_configuration("config.xml");

	}

}
