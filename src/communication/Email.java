package communication;

import data.Problem;

public class Email {

	private String from;
	private String to;
	private String admin;
	private String subject;
	private String messageBody;
	private String fileName;
	private Problem problem;

	public Email() {
		from = "geral.nemesis@gmail.com";
		admin = "geral.nemesis@gmail.com";
		fileName = "quiz.txt";
	}

	public void welcome_email(String to) {
		this.to = to;
		subject = "Optimiza��o em curso: " + "(Nome do problema)" + "(Ano-M�s-Dia Hora:Minuto)";
		messageBody = "<html><body><p>Muito obrigado por usar esta plataforma de otimiza��o.<br />"
				+ "Ser� informado por email sobre o progresso do processo de otimiza��o, quando o processo de otimiza��o tiver atingido 25%, 50%, 75% do total do tempo estimado, e tamb�m quando o processo tiver terminado, com sucesso ou devido � ocorr�ncia de erros. <br /><br />"
				+ "Tempo de optimiza��o estimado:" + "(Tempo estimado)" + "<br /><br />"
				+ "Atenciosamente N�mesis</p></body></html>";
	}

	public void progression_email(String to, Double progress) {
		this.to = to;
		subject = "Progresso da Optimiza��o: " + "(Nome do problema)" + "(Ano-M�s-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimiza��o encontra-se " + progress + "% concluido.<br /><br />"
				+ "Tempo de optimiza��o estimado:" + "(Tempo estimado)" + "<br /><br />"
				+ "Atenciosamente N�mesis</p></body></html>";
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

	public String getFileName() {
		return fileName;
	}
	
	

}
