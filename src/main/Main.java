package main;

import communication.EmailSender;

public class Main {

	public static void main(String[] args) {
		EmailSender email = new EmailSender();
		email.sendMail("rodolfo.afa@gmail.com", null , "welcome", "quiz.txt");
		//EmailSender.sendMail("rodolfo.afa@gmail.com", "welcome", "quiz.txt");

	}

}
