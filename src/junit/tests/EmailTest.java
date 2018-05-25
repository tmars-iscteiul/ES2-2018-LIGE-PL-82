package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.comm.Email;
import data.submission.Submission;

public class EmailTest {
	
	@Test
	public void attributes() {
		Email tester = new Email(new Submission());

        assertNotNull(tester.getAdmin());
        assertNotNull(tester.getFrom());
        assertNotNull(tester.getProblem());
        
        tester.welcome_email("test@gmail.com");
        assertNotNull(tester.getTo());
        assertEquals("test@gmail.com", tester.getTo());
	}

}
