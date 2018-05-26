package data.comm;
import java.time.LocalDateTime;

import data.problem.Problem;
import data.submission.Submission;

public class Email {

	private String from;
	private String to;
	private String admin;
	private String subject;
	private String messageBody;
	//private String fileName;
	private Problem problem;

	public Email(Problem problem) {
		this.problem = problem;
		from = "geral.nemesis@gmail.com";
		admin = "geral.nemesis@gmail.com";
		//fileName = "quiz.txt";
	}

	public void welcome_email() {
		this.to = problem.getIntroduction().getUserEmail();
		subject = "Optimização em curso: " + problem.getIntroduction().getName() + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Bem-vindo à Nêmesis</h1><p>Muito obrigado por usar esta plataforma de otimização.<br />"
				+ "O seu processo de otimização iniciou com sucesso. Será informado por email sobre o progresso do mesmo.<br/><br/>"
				+ "Tempo de optimização estimado: " + problem.getIntroduction().getAverageDuration().getValue("min") + " minutos <br /><br />"
				+ "Atenciosamente, <br/>Equipa da Nêmesis</p></body></html>";
	}

	public void progression_email(String to, double progress, int minutesLeft) {
		this.to = to;
		subject = "Progresso da Optimização: " + problem.getIntroduction().getName() + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Processo de Otimização</h1><p>O processo de optimizaçãoo encontra-se " + progress + "% concluido.<br /><br />"
				+ "Tempo restante de optimização estimado: " + minutesLeft + "<br /><br />"
				+ "Atenciosamente, <br/>Equipa da Nêmesis</p></body></html>";
	}

	public void success_email(String to) {
		this.to = to;
		subject = "Conclus�o da Optimiza��o: " + "(Nome do problema)" + "(Ano-M�s-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimiza��o foi conluido com sucesso.<br /><br />"
				+ "Atenciosamente N�mesis</p></body></html>";
	}

	public void fail_email(String to) {
		subject = "Interrup��o da Optimiza��o: " + "(Nome do problema)" + "(Ano-M�s-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimiza��o n�o foi conluido devido a um erro.<br /><br />"
				+ "Siga os passos para resolu��o do problema:<br />"
				+ "1 - Recarregue o ficheiro com a defini��o do problema;<br />"
				+ "2 - Verifique se todos os campos est�o correctamente preenchidos;<br />"
				+ "3 - Submeta novamente o problema.<br /><br />"
				+ "Pedimos desculpa pelo incomodo causado.<br /><br />" + "Atenciosamente N�mesis</p></body></html>";
	}
	
	public void time_exceeded(double progress)	{
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
	
	
	
	

	//public String getFileName() {
	//	return fileName;
	//}
	
	

}
