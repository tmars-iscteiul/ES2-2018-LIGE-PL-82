package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.submission.Feedback;

public class DataSubmissionTester {

	@Test
	public void test() {
		Feedback tester = new Feedback("name", "test@gmail.com", "subject", "emailText");
		assertEquals("name",tester.getName());
		assertEquals("test@gmail.com", tester.getEmail());
		assertEquals("subject", tester.getSubject());
		assertEquals("emailText", tester.getEmailText());
	}

}
