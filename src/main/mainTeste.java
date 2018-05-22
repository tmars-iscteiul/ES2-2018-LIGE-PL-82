package main;

import data.problem.Problem;
import data.problem.ProblemInputs;
import threads.JMetalWorker;

public class mainTeste {

	/*
	 * This class was created for testing the JMetal process without the Web interface
	 */
	
	public static void main(String[] args) {
		
		ProblemInputs pinputs= new ProblemInputs();
		pinputs.addConfiguration("Anti-spamFilter", -5.0, 5.0, "double" , 10, "teste do SpamEmail Problem");
		Problem p= new Problem(pinputs);
		
		// falta um parametro ou Integer numberOfVariables ou  Integer numberOfObjetives,
		
		new JMetalWorker(p);
	}
	
}
