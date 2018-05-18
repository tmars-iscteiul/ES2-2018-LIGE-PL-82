package threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.problem.Problem;
import utilities.ConsoleLogger;

/**
 * This thread will run algorithm calculation, so that multiple algorithms can be running at the same time.
 * This class will also be responsible for calculating the process's completion percentage, and call the EmailSender to send the respective emails to the user.
 * 
 * @author skner
 *
 */
public class JMetalWorker extends Thread {

	private Problem problem;
	private ConsoleLogger workerLogger;
	
	public JMetalWorker(Problem problem)	{
		this.problem = problem;
		workerLogger = new ConsoleLogger("JMETALWORKER");
		start();
	}
	
	@Override
	public void run()	{
		//Here is where the algorithm calls will be made.
		workerLogger.writeConsoleLog("Received problem class. Here's some fields to demonstrate the correct receiving.");

	}
	
}
