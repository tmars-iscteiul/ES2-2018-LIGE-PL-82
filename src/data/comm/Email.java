package data.comm;
import java.time.LocalDateTime;

import data.problem.Problem;

public class Email {

	private String from;
	private String to;
	private String admin;
	private String subject;
	private String messageBody;
	private Problem problem;
	private String problemName;
	private int currentType;

	public Email(Problem problem) {
		this.problem = problem;
		from = "geral.nemesis@gmail.com";
		admin = "geral.nemesis@gmail.com";
		to = problem.getIntroduction().getUserEmail();
		problemName = problem.getIntroduction().getName();
	}

	public void welcome_email() {
		currentType = 0;
		subject = "Beginning of Optimization: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Welcome to Nêmesis</h1><p>Thank you for choosing this optimization platform.<br />"
				+ "Your optimization problem started with success. You will be inform about the progression of the process.<br/><br/>"
				+ "Estimated optimization time: " + problem.getIntroduction().getAverageDuration().getValue("min") + " minutes <br /><br />"
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}

	public void progression_email(double progress, int minutesLeft) {
		currentType = 1;
		subject = "Optimization progress: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization progress status</h1>"
				+ "<p>The optimization process is " + progress + "% complete.<br /><br />"
				+ "Estimated optimization time left: " + minutesLeft + " minutes<br /><br />"
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}

	public void success_email() {
		currentType = 2;
		subject = "Optimization process complete: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization process complete</h1>"
				+ "<p>Your optimization problem was finished with success.<br /><br />"
				+ "To check the optimization results go to the link below:<br />"
				+ "<a href=\"http://localhost:4100/?problemName=" + problemName + "\">"
				+ "http://localhost:4100/?problemName=" + problemName + "</a><br/><br/>"
				+ "You can see the variables final results in the file attached.<br/><br/>"
				+ "See you next time, <br/>Nêmesis Team</p></body></html>";
	}

	public void fail_email() {
		currentType = 3;
		subject = "Optimization process interrupted: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><p>Nêmesis - Optimization process interrupted<br /><br />"
				+ "Your process was interrupted due to failure in the choosen parameters. We suggest the following steps:<br />"
				+ "1 - Check if the information of the inputs is correct and congruent with the optimizers.<br />"
				+ "2 - Assure that the fitness jar application or the given URL are valid;<br />"
				+ "3 - If any of these steps are correct, send us the feedback for us to analyse.<br /><br />"
				+ "Sorry about the incovinience.<br /><br />" 
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}
	
	public void time_exceeded(double progress)	{
		currentType = 4;
		subject = "Optimization process time exceeded: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization process time exceeded</h1>"
				+ "<p>Your optimization process ended due to reaching the maximum time limit.<br /><br />"
				+ "To check the last optimization results go to the link below:<br />"
				+ "<a href=\"http://localhost:4100/?problemName=" + problemName + "\">"
				+ "http://localhost:4100/?problemName=" + problemName + "</a><br/><br/>"
				+ "You can see the variables final results in the file attached.<br/><br/>"
				+ "If you want to get better results we suggest increasing the process time, or choosing less optimizer algorithms."
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
		
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getAdmin() {
		return admin;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setTo(String to) {
		this.to = to;
	}


	public int getCurrentType() {
		return currentType;
	}

	public String getProblemName() {
		return problemName;
	}
	

}
