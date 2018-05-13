package data.problem.temp;

public class Feedback {
	private String name;
	private String email;
	private String subject;
	private String emailText;
	
	public Feedback(String name, String email, String subject, String emailText) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.emailText = emailText;
	}
	
	public Feedback() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}
	
	
}
