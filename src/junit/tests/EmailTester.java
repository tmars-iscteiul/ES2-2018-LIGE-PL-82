package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.comm.Email;
import data.comm.EmailSender;
import data.problem.Problem;
import data.submission.Submission;

public class EmailTester {
	
	@Test
	public void emailAttributes() {
		Email tester = new Email(new Problem());
        assertNotNull(tester.getAdmin());
        assertNotNull(tester.getFrom());
        assertNotNull(tester.getProblem());
        assertNull(tester.getSubject());
        assertNull(tester.getMessageBody());
        assertNull(tester.getTo());
	}
	
	@Test
	public void emailSenderAttributes() {
		EmailSender tester = new EmailSender();
		assertEquals("smtp.gmail.com", tester.getHost());
		assertNotNull(tester.getAuthenticator());
		assertNotNull(tester.getProperties());
	}
	
}
