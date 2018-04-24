package main;

import java.util.ArrayList;

import JMetal.DoubleConfiguration;
import data.Configuration;
import data.problem.Problem;
import stakeholders.Administrator;

public class Engine extends Thread	{

	//private Administrator admin; TODO Why do we need this?
	private ArrayList<Configuration> configurationList; // Queue?
	
	
	
	public Engine() {
		
	}
	
	@Override
	public void run()	{
		
		
		/*
		 * Receives input from WEB GUI through JSON to run JMETAL'S ALGORITHMS. Sends results through email.
		 *   Imports JSON and reads it (needs JSON's final structure)
		 *   Splits every algorithm run with jMetalHandler, using data.Problem
		 *   Executes every algorithm (jMetalHandler, after given the right inputs)
		 *   During execution, jMetalHandler calls EmailSender to send emails on progress (Progress, ETA and other stats...)
		 *   After generating, saves results (how? TBD) and sends to email.
		 *   Closes.
		 *   
		 */
		
		
	}
	
	public void executeAlgorithm() {
		//DoubleConfiguration();
	}

	
	
	
	
}
