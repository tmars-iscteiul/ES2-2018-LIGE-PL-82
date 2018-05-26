package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.problem.Problem;
import data.problem.ProblemFitnessApp;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import data.problem.ProblemOptimization;
import threads.JMetalWorker;
import utilities.TimeVariable;

public class ThreadTester {
	
	private ProblemIntroduction introduction = new ProblemIntroduction("name", "fullDescription", new TimeVariable (2.0, "sec"), new TimeVariable (10.0, "min"), "test@gmail.com");
	private ProblemInputs inputs = new ProblemInputs(); 
	private ProblemOptimization optimization = new ProblemOptimization(); 
	private ProblemFitnessApp fitnessApp = new ProblemFitnessApp("D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar", 20);
	
	@Test
	public void jmetalWorker() {
		Problem prob = new Problem(introduction,inputs, optimization,fitnessApp);
		JMetalWorker tester = new JMetalWorker(prob);
	}

}
