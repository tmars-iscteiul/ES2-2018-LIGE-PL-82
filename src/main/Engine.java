package main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Service;

import org.codehaus.jackson.map.ObjectMapper;

import data.AdminOptions;
import data.comm.Email;
import data.comm.EmailSender;
import data.problem.Problem;
import data.submission.Feedback;
import data.submission.Submission;
import threads.JMetalWorker;
import threads.ProcessManager;
import utilities.ConsoleLogger;

/**
 * The engine is the main worker of the software. It will be in charge of following the software's logical process.
 * It also manages data and handlers/workers, providing necessary inputs and resolving outputs.
 * 
 * @author skner
 *
 */
@Service
public class Engine extends Thread	{
	
	private BlockingQueue<Problem> problemQueue;
	private ConsoleLogger logger;
	
	private AdminOptions options;
	
	public Engine()	{
		problemQueue = new ArrayBlockingQueue<Problem>(1024);
		logger = new ConsoleLogger("ENGINE");
		ObjectMapper mapper = new ObjectMapper();
		try {
			options = mapper.readValue(new File("./config.json"), AdminOptions.class);
			logger.writeConsoleLog("config.json loaded.");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		logger.writeConsoleLog("Engine is running and awaiting inputs...");
		while(true) {
			try {
				new ProcessManager(new JMetalWorker(problemQueue.take(), options));
				logger.writeConsoleLog("Submission received. Starting problem process.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void executeAlgorithm() {
	}
	
	public void addProblemToQueue(Submission submission)	{
		// TODO Add submission_feedback email sender
		if(submission.getFeedback().getEmail() != "") {
			logger.writeConsoleLog("User sent feedback. Sending to admin: " + options.getAdminEmail() + ".");
			sendFeedbackToAdmin(submission);
		}
		problemQueue.add(new Problem(submission));
	}

	public void sendFeedbackToAdmin(Submission submission) {
		Email email = new Email(new Problem(submission), options);
		email.feedback(submission.getFeedback());
		new EmailSender().sendMail(email);
	}
	
	public void sendOnlyFeedbackToAdmin(Submission submission) {
		Email email = new Email(options);
		email.feedbackOnly(submission.getFeedback());
		new EmailSender().sendMail(email);
	}

	public String getStatus()	{
		if(problemQueue.size() < 1)	{
			return "ENGINE STATUS: Awaiting inputs";
		}	else	{
			return "ENGINE STATUS: Computing...";
		}
	}

	public BlockingQueue<Problem> getProblemQueue() {
		return problemQueue;
	}

	public ConsoleLogger getEngineLogger() {
		return logger;
	}
	
	

}
