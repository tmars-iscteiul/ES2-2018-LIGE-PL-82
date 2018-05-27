package threads;

import data.comm.Email;
import data.comm.EmailSender;
import utilities.ConsoleLogger;
import utilities.VariableType;

/**
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
		while(worker.isAlive())	{
			logger.writeConsoleLog("Progress: " + String.format("%.2f", getProgress()*100) + "%");
			checkMaxTimeLimit();
			try {
				sleep(updateTimer * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.writeConsoleLog("Worker has stopped running.");
	}
	
	private double getRunTime()	{
		return System.currentTimeMillis() - startTime;
	}
	
	private double getProblemAverageMaxRatio()	{
		return (worker.getProblem().getIntroduction().getAverageDuration().getValue("ms")/worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"));
	}
	
	private float getProgress()	{
		if(worker.getExperiment().getProblemVarType().equals(VariableType.varBoolean))
			return ((float)worker.getExperiment().getMyBinaryProblem().getCalculatedConfigurations()/worker.getExperiment().getTotalConfigurations());
		else if(worker.getExperiment().getProblemVarType().equals(VariableType.varDouble))
			return ((float)worker.getExperiment().getMyDoubleProblem().getCalculatedConfigurations()/worker.getExperiment().getTotalConfigurations());
		else
			return ((float)worker.getExperiment().getMyIntegerProblem().getCalculatedConfigurations()/worker.getExperiment().getTotalConfigurations());
	}

	private void checkMaxTimeLimit()	{
		if(getRunTime() > worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"))	{
			Email email = new Email(worker.getProblem());
			email.time_exceeded(getProgress());
			new EmailSender().sendMail(email);
			logger.writeConsoleLog("Process has reached the time limit of " + worker.getProblem().getIntroduction().getMaxDuration().getValue("sec") + "sec.");
			worker.stop();// TODO Replace with a safer stop of JMETAL.
		}
		
		if(getRunTime() > worker.getProblem().getIntroduction().getAverageDuration().getValue("ms"))	{
			if(getProgress() < getProblemAverageMaxRatio())	{
				// TODO Run time reached average duration, but progress isn't high enough. It might exceed max duration
			}
		}
	}
}
