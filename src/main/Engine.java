package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Service;

import data.comm.Email;
import data.comm.EmailSender;
import data.problem.Configuration;
import data.problem.Problem;
import data.problem.Restriction;
import data.submission.Introduction;
import data.submission.Submission;
import threads.JMetalWorker;
import utilities.Algorithm;
import utilities.ConsoleLogger;
import utilities.TimeVariable;

/**
 * The engine is the main worker of the software. It will be in charge of following the software's logical process.
 * It also manages data and handlers/workers, providing necessary inputs and resolving outputs.
 * 
 * @author skner
 *
 */
@Service
public class Engine extends Thread	{

	//private Administrator admin; TODO Why do we need this?
	private BlockingQueue<Problem> problemQueue;
	private Submission problem;
	private ConsoleLogger engineLogger;
	
	public Engine()	{
		problemQueue = new ArrayBlockingQueue<Problem>(1024);
		engineLogger = new ConsoleLogger("ENGINE");
		engineLogger.writeConsoleLog("Engine has been created.");
		start();
	}
	
	/**
	 * Receives input from WEB GUI through JSON to run JMETAL'S ALGORITHMS. Sends results through email.
	 *   Receives JSON from SPRING APP (needs JSON's final structure)
	 *   This object will hold the information to be passed to the JMETAL algorithms
	 *   Splits every algorithm run with jMetalHandler, using data.ProblemInputs's configuration list
	 *   Executes every algorithm (jMetalHandler, after given the right inputs)
	 *   During execution, jMetalHandler calls EmailSender to send emails on progress (Progress, ETA and other stats...)
	 *   After generating, saves results (how? TBD) and sends to email.
	 *   
	 */
	@Override
	public synchronized void run()	{
		engineLogger.writeConsoleLog("Engine is running and awaiting inputs...");
		while(true) {
			try {
				new JMetalWorker(problemQueue.take());
				engineLogger.writeConsoleLog("Submission received. Starting problem process.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void executeAlgorithm() {
	}
	
	public void addProblemToQueue(Submission submission)	{
		Email email = new Email(submission);
		email.welcome_email(submission.getMainInformation().getUserEmail());
		new EmailSender().sendMail(email);

		// TODO Add submission_feedback email sender
		problemQueue.add(new Problem(submission));
	}

	public String getStatus()	{
		if(problemQueue.size() < 1)	{
			return "ENGINE STATUS: Awaiting inputs";
		}	else	{
			return "ENGINE STATUS: Computing...";
		}
	}

}
