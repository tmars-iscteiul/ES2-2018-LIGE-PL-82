package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class Feedback {
	
	/*
	 * Feedback {name, email, subject, emailText}
	 */
	
	@JsonProperty("name")private String name;
	@JsonProperty("email")private String email;
	@JsonProperty("subject")private String subject;
	@JsonProperty("emailText")private String emailText;
	
	public Feedback()	{
	}
	
	public Feedback(String name, String email, String subject, String emailText) {
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.emailText = emailText;
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
