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
	private Submission problem;

	public Email(Submission problem) {
		this.problem = problem;
		from = "geral.nemesis@gmail.com";
		admin = "geral.nemesis@gmail.com";
		//fileName = "quiz.txt";
	}

	public void welcome_email(String to) {
		this.to = to;
		subject = "Optimização em curso: " + problem.getMainInformation().getProblemName() + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Bem-vindo à Nêmesis</h1><p>Muito obrigado por usar esta plataforma de otimização.<br />"
				+ "O seu processo de otimização iniciou com sucesso. Será informado por email sobre o progresso do mesmo.<br/><br/>"
				+ "Tempo de optimização estimado: " + problem.getMainInformation().getAverageDuration() + ' ' + problem.getMainInformation().getAverageScale() + "<br /><br />"
				+ "Atenciosamente, <br/>Equipa da Nêmesis</p></body></html>";
	}

	public void progression_email(String to, Double progress) {
		this.to = to;
		subject = "Progresso da Optimização: " + problem.getMainInformation().getProblemName() + " - " + LocalDateTime.now();
		messageBody = "<html><body><h1>Nêmesis - Processo de Otimização</h1><p>O processo de optimizaçãoo encontra-se " + progress + "% concluido.<br /><br />"
				+ "Tempo de optimização estimado: " + problem.getMainInformation().getAverageDuration()*progress + ' ' + problem.getMainInformation().getAverageScale() + "<br /><br />"
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

	//public String getFileName() {
	//	return fileName;
	//}
	
	

}
