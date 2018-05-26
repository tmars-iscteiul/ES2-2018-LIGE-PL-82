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
		subject = "Interrupção da Optimização: " + problemName + " - " + LocalDateTime.now();
		messageBody = "<html><body><p>O processo de optimiza��o n�o foi conluido devido a um erro.<br /><br />"
				+ "Siga os passos para resolu��o do problema:<br />"
				+ "1 - Recarregue o ficheiro com a defini��o do problema;<br />"
				+ "2 - Verifique se todos os campos est�o correctamente preenchidos;<br />"
				+ "3 - Submeta novamente o problema.<br /><br />"
				+ "Pedimos desculpa pelo incomodo causado.<br /><br />" + "Atenciosamente N�mesis</p></body></html>";
	}
	
	public void time_exceeded(double progress)	{
		currentType = 4;
		this.to = problem.getIntroduction().getUserEmail();
		subject = "Tempo máximo excedido: " + problem.getIntroduction().getName() + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Processo de Otimização. </h1><br /><br />O processo de optimização foi interrompido devido a ter excedido o tempo limite"
				+ "O processo parou em " + String.format("%.2f", progress) + "%, tendo atingido o tempo limite de " 
				+ String.format("%", (problem.getIntroduction().getMaxDuration().getValue("min")*100)) + " minutos. Caso pretenda que o processo conclua, terá de submeter o processo"
				+ " novamente, aumentando o valor do tempo limite. <br /><br />"
				+ "Atenciosamente, <br/>Equipa da Nêmesis</p></body></html>";
		
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
