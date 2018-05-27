package data.comm;
import java.time.LocalDateTime;

import data.AdminOptions;
import data.problem.Problem;

/**
 * An email object. Contains fields so that @see EmailSender can send the email correctly.
 * @author skner
 *
 */
public class Email {

	private String from;
	private String to;
	private String admin;
	private String subject;
	private String messageBody;
	private Problem problem;
	private String problemName;
	private int currentType;

	public Email(Problem problem, AdminOptions options) {
		this.problem = problem;
		from = options.getAdminEmail();
		admin = options.getAdminEmail();
		to = problem.getIntroduction().getUserEmail();
		problemName = problem.getIntroduction().getName();
	}

	public void welcome_email() {
		currentType = 0;
		subject = "Optimization process started: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Welcome to Nêmesis</h1><p>Thank you for choosing this optimization platform.<br />"
				+ "Your optimization problem has launched with success. You will be informed about its progression as it happens.<br/><br/>"
				+ "We will keep you informed on your problem's progression. We will send an email every 25% of total progress with more information. <br /><br />"
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}

	public void progression_email(int progress, int minutesLeft) {
		currentType = 1;
		subject = "Optimization progress: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization progress status</h1>"
				+ "<p>The optimization process is " + progress + "% completed.<br /><br />"
				+ "Estimated optimization time left: " + minutesLeft + " minutes.<br /><br />"
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}

	public void success_email() {
		currentType = 2;
		subject = "Optimization process completed: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization process complete</h1>"
				+ "<p>Your optimization problem has successfully finished.<br /><br />"
				+ "You can view the optimization results by following the link below:<br />"
				+ "<a href=\"http://localhost:4100/?problemName=" + problemName + "\">"
				+ "http://localhost:4100/?problemName=" + problemName + "</a><br/><br/>"
				+ "You can also see the variables' final results in the attached file.<br/><br/>"
				+ "See you next time, <br/>Nêmesis Team</p></body></html>";
	}

	public void fail_email() {
		currentType = 3;
		subject = "Optimization process interrupted: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><p>Nêmesis - Optimization process interrupted<br /><br />"
				+ "Your process was interrupted due to failure in the choosen parameters. We suggest the following steps:<br />"
				+ "1 - Check if the information of the inputs is correct and congruent with the evaluators.<br />"
				+ "2 - Assure that the fitness jar application or the given URL are valid;<br />"
				+ "3 - If any of these steps are correct, send us the feedback for us to analyse.<br /><br />"
				+ "Sorry about the inconvenience.<br /><br />" 
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}
	
	public void time_exceeded(int progress)	{
		currentType = 4;
		subject = "Optimization process time exceeded: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Optimization process time exceeded</h1>"
				+ "<p>Your optimization process ended due to reaching the maximum time limit.<br /><br />"
				+ "If you want to get your results, we suggest increasing the process time, or choosing less optimizer algorithms. <br /><br />"
				+ "Our best regards, <br/>Nêmesis Team</p></body></html>";
	}
	
	public void feedback(data.submission.Feedback feedback)	{
		currentType = 5;
		to = admin;
		subject = "User Feedback: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - User Feedback</h1>"
				+ "<p>An user identified by \"" + feedback.getName() + "\" has provided feedback: <br /><br />"
				+ feedback.getSubject() + " <br /><br />"
				+ feedback.getEmailText() + " <br /><br />"
				+ "</p></body></html>";
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
