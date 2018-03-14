package communication;

public class Email {

	private String from;
	private String to;
	private String admin;
	private String subject;
	private String messageBody;
	private String fileName;

	public Email() {
		System.out.println("Email created");
		from = "geral.nemesis@gmail.com";
		admin = "geral.nemesis@gmail.com";
		fileName = "quiz.txt";
	}

	public void welcome_email(String to) {
		this.to = to;
		subject = "Optimização em curso: " + "(Nome do problema)" + "(Ano-Mês-Dia Hora:Minuto)";
		messageBody = "<html><body><p>Muito obrigado por usar esta plataforma de otimização.<br />"
				+ "Será informado por email sobre o progresso do processo de otimização, quando o processo de otimização tiver atingido 25%, 50%, 75% do total do tempo estimado, e também quando o processo tiver terminado, com sucesso ou devido à ocorrência de erros. <br /><br />"
				+ "Tempo de optimização estimado:" + "(Tempo estimado)" + "<br /><br />"
				+ "Atenciosamente Nêmesis</p></body></html>";
	}

	public void progression_email(String to, Double progress) {
		this.to = to;
		subject = "Progresso da Optimização: " + "(Nome do problema)" + "(Ano-Mês-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimização encontra-se " + progress + "% concluido.<br /><br />"
				+ "Tempo de optimização estimado:" + "(Tempo estimado)" + "<br /><br />"
				+ "Atenciosamente Nêmesis</p></body></html>";
	}

	public void success_email(String to) {
		this.to = to;
		subject = "Conclusão da Optimização: " + "(Nome do problema)" + "(Ano-Mês-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimização foi conluido com sucesso.<br /><br />"
				+ "Atenciosamente Nêmesis</p></body></html>";
	}

	public void fail_email(String to) {
		subject = "Interrupção da Optimização: " + "(Nome do problema)" + "(Ano-Mês-Dia Hora:Minuto)";
		messageBody = "<html><body><p>O processo de optimização foi conluido devido a um erro.<br /><br />"
				+ "Siga os passos para resolução do problema:<br />"
				+ "1 - Recarregue o ficheiro com a definição do problema;<br />"
				+ "2 - Verifique se todos os campos estão correctamente preenchidos;<br />"
				+ "3 - Submeta novamente o problema.<br /><br />"
				+ "Pedimos desculpa pelo incomodo causado.<br /><br />" + "Atenciosamente Nêmesis</p></body></html>";
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
