package main;

import java.util.ArrayList;

import data.Configuration;
import data.Restriction;
import data.problem.Problem;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import data.problem.ProblemOptimization;
import utils.Algorithms;
import utils.TimeVariable;

/**
 * The engine is the main worker of the software. It will be in charge of following the software's logical process.
 * It also manages data and handlers/workers, providing necessary inputs and resolving outputs.
 * 
 * @author skner
 *
 */
public class Engine extends Thread	{

	//private Administrator admin; TODO Why do we need this?
	private Problem problem;
	
	public Engine() {
		
	}
	
	/**
	 * Receives input from WEB GUI through JSON to run JMETAL'S ALGORITHMS. Sends results through email.
	 *   Imports JSON and reads it (needs JSON's final structure), returning a PorlbmeInputs class, with Configurations List.
	 *   This list will hold the information to be passed to the JMETAL algorithms
	 *   Splits every algorithm run with jMetalHandler, using data.ProblemInputs's configuration list
	 *   Executes every algorithm (jMetalHandler, after given the right inputs)
	 *   During execution, jMetalHandler calls EmailSender to send emails on progress (Progress, ETA and other stats...)
	 *   After generating, saves results (how? TBD) and sends to email.
	 *   Closes.
	 */
	@Override
	public void run()	{
		readJson();
		
	}
	
	/**
	 * Reads the JSON File through Spring's framework. 
	 * While the framework is being implemented, this method creates place-holders for the data structures
	 */
	private void readJson()	{
		TimeVariable averageDuration = new TimeVariable(60, "min");
		TimeVariable maxDuration = new TimeVariable(120, "min");
		ProblemIntroduction pintro = new ProblemIntroduction("Example Problem", "No description", averageDuration, maxDuration, "test@nemesis.com");
		problem.setIntroduction(pintro);
		
		ProblemInputs pinputs = new ProblemInputs("Example Problem Inputs");
		pinputs.addConfiguration(new Configuration("config1", -5.0, 5.0, "double", 20));
		pinputs.addConfiguration(new Configuration("config1", -5.0, 5.0, "double", 20));
		pinputs.addRestriction(new Restriction("Can't be 0", "!=", 0));
		problem.setInputs(pinputs);
		
		ArrayList<Algorithms> algorithmList = new ArrayList<Algorithms>();
		algorithmList.add(Algorithms.nsgaii);
		ProblemOptimization poptimization = new ProblemOptimization(algorithmList);
		problem.setOptimization(poptimization);
		
		// Fitness app? Just make a place holder one to calculate the example ones.
		// Feedback not necessary
		
	}
	
	public void executeAlgorithm() {
	}

}
