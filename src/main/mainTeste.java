package main;

import data.problem.Problem;
import data.problem.ProblemFitnessApp;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import threads.JMetalWorker;
import utilities.TimeVariable;

public class mainTeste {

	/*
	 * This class was created for testing the JMetal process without the Web interface
	 */
	
	public static void main(String[] args) {
		
		ProblemInputs pinputs= new ProblemInputs();
		pinputs.addConfiguration("Anti-spamFilter", -5.0, 5.0, "double", 10, "teste do SpamEmail Problem");
		ProblemFitnessApp pFitness= new ProblemFitnessApp("antiSpamProblem.jar", 2);
		
		
		Problem p = new Problem();
		p.setIntroduction(new ProblemIntroduction("antiSpamTest", "", new TimeVariable(30.0f, "min"), new TimeVariable(60.0f, "min"), "test@test.test"));
		p.setInputs(pinputs);
		p.setFitnessApp(pFitness);
		
		
		// falta um parametro ou Integer numberOfVariables ou  Integer numberOfObjetives,
		
		new JMetalWorker(p);

	}
	
}
