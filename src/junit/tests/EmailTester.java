package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.AdminOptions;
import data.comm.Email;
import data.comm.EmailSender;
import data.problem.Problem;
import data.problem.ProblemFitnessApp;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import data.problem.ProblemOptimization;
import utilities.TimeVariable;

/**
 * JUnit tests the email sender
 * @author skner
 *
 */
public class EmailTester {
	private ProblemIntroduction introduction = new ProblemIntroduction("name", "fullDescription", new TimeVariable (2.0, "sec"), new TimeVariable (10.0, "min"), "test@gmail.com");
	private ProblemInputs inputs = new ProblemInputs(); 
	private ProblemOptimization optimization = new ProblemOptimization(); 
	private ProblemFitnessApp fitnessApp = new ProblemFitnessApp("D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar", 20);
	
	@Test
	public void emailAttributes() {
		Problem prob = new Problem(introduction, inputs, optimization, fitnessApp);
		Email tester = new Email(prob, new AdminOptions());
		tester.setTo("rodolfo.afa@gmail.com");
        assertNotNull(tester.getAdmin());
        assertNotNull(tester.getFrom());
        assertNotNull(tester.getProblem());
        assertNull(tester.getSubject());
        assertNull(tester.getMessageBody());
        assertNotNull(tester.getTo());
        
        tester.fail_email();
        tester.progression_email(75, 10);
        tester.welcome_email();
        tester.success_email();
        assertNotNull(tester.getCurrentType());
        assertNotNull(tester.getProblemName());
	}
	
	@Test
	public void emailSenderAttributes() {
		EmailSender tester = new EmailSender();
		assertEquals("smtp.gmail.com", tester.getHost());
		assertNotNull(tester.getAuthenticator());
		assertNotNull(tester.getProperties());
	}
	
}
