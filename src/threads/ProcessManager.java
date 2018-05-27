package threads;

import data.comm.Email;
import data.comm.EmailSender;
import utilities.ConsoleLogger;
import utilities.VariableType;

/**
 * This class will support each JMetalWorker, verifying certain situations while JMetalWorker is busy running the algorithms.
 * @author skner
 *
 */
public class ProcessManager extends Thread	{
	
	private final double startTime;
	private final int updateTimer;
	private JMetalWorker worker;
	private ConsoleLogger logger;
	
	public ProcessManager(JMetalWorker worker)	{
		// TODO Way to check minimum time to send emails (spam)
		updateTimer = 5;
		startTime = System.currentTimeMillis();
		this.worker = worker;
		logger = new ConsoleLogger("PROCESS-MANAGER");
		start();
	}
	
	@Override
	public synchronized void run()	{
		logger.writeConsoleLog("Process Manager has started, following the " + worker.getProblem().getIntroduction().getName() + "'s worker.");
		try {
			sleep(updateTimer * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int progressEmailingCheckpoint = 25;
		while(worker.isAlive())	{
			worker.setRunTime(getRunTime());
			logger.writeConsoleLog(worker.getProblem().getIntroduction().getName() + "'s progress: " + String.format("%.2f", getProgress()*100) + "%");
			checkMaxTimeLimit();
			if(getProgress()*100 > progressEmailingCheckpoint && progressEmailingCheckpoint != 100)	{
				// Sends progress emails every 25%
				Email email = new Email(worker.getProblem(), worker.getAdminOptions());
				email.progression_email((int)(getProgress()*100), getAproxTimeLeft()/60000);
				new EmailSender().sendMail(email);
				progressEmailingCheckpoint += progressEmailingCheckpoint;
			}
			try {
				sleep(updateTimer * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.writeConsoleLog("Worker has stopped running. Terminating manager.");
		worker.setRunTime(getRunTime());
	}
	
	private int getAproxTimeLeft() {
		return (int)(getRunTime()/worker.getExperiment().getCompletedRuns()) * (worker.getExperiment().getTotalRuns()-worker.getExperiment().getCompletedRuns());
	}

	private double getRunTime()	{
		return System.currentTimeMillis() - startTime;
	}

	
	private float getProgress()	{
		return ((float)worker.getExperiment().getCompletedRuns()/worker.getExperiment().getTotalRuns());
	}

	private void checkMaxTimeLimit()	{
		if(getRunTime() > worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"))	{
			logger.writeConsoleLog("Process has reached the time limit of " + worker.getProblem().getIntroduction().getMaxDuration().getValue("sec") + "sec.");
			worker.setRunTime(getRunTime());
			Email email = new Email(worker.getProblem(), worker.getAdminOptions());
			email.time_exceeded((int)getProgress()*100);
			new EmailSender().sendMail(email);
			worker.stop();// TODO Replace with a safer stop of JMETAL.
		}

	}
}
