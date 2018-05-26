package junit.tests;

import static org.junit.Assert.*;
import utilities.TimeVariable;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

import data.problem.Problem;
import data.problem.ProblemFitnessApp;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import data.problem.ProblemOptimization;
import data.submission.Faqs;
import data.submission.Feedback;
import data.submission.FitnessApp;
import data.submission.Inputs;
import data.submission.Introduction;
import data.submission.MainInformation;
import data.submission.Optimization;
import utilities.TimeVariable;

public class ProblemTester {
	private ProblemIntroduction introduction = new ProblemIntroduction("name", "fullDescription", new TimeVariable (2.0, "sec"), new TimeVariable (10.0, "min"), "test@gmail.com");
	private ProblemInputs inputs = new ProblemInputs(); 
	private ProblemOptimization optimization = new ProblemOptimization(); 
	private ProblemFitnessApp fitnessApp = new ProblemFitnessApp("D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar", 20);
	
	private Introduction subintroduction;
	private MainInformation submainInformation;
	private Inputs inputs;
	private FitnessApp fitnessApp;
	private Optimization optimization;
	private Feedback feedback;
	private Faqs faqs;
	
	
	@Test
	public void problem() {
		Problem tester = new Problem(null, null, null, null);
		assertNull(tester.getFitnessApp());
		tester.setFitnessApp(fitnessApp);
		tester.setInputs(inputs);
		tester.setIntroduction(introduction);
		tester.setOptimization(optimization);
		assertNotNull(tester.getIntroduction());
		assertNotNull(tester.getFitnessApp());
		assertNotNull(tester.getInputs());
		assertNotNull(tester.getOptimization());
	}
	
	/*@Test
	public void submission() {
		
	}*/

}
