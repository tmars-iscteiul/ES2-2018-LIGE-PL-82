package threads;

import utilities.ConsoleLogger;

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
		logger = new ConsoleLogger("PROCESSMANAGER");
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
			logger.writeConsoleLog("Progress: " + getProgress()*100 + "%");
			checkMaxTimeLimit();
			try {
				sleep(updateTimer * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.writeConsoleLog("Worker has died.");
	}
	
	private double getRunTime()	{
		return System.currentTimeMillis() - startTime;
	}
	
	private double getProblemAverageMaxRatio()	{
		return (worker.getProblem().getIntroduction().getAverageDuration().getValue("ms")/worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"));
	}
	
	private float getProgress()	{
		return ((float)worker.getExperimentDouble().getMyProblem().getCalculatedConfigurations()/worker.getExperimentDouble().getTotalConfigurations());
	}

	private void checkMaxTimeLimit()	{
		if(getRunTime() > worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"))	{
			// TODO: Time limit exceeded
		}
		
		if(getRunTime() > worker.getProblem().getIntroduction().getAverageDuration().getValue("ms"))	{
			// TODO: Check if time MIGHT exceed max
			if(getProgress() < getProblemAverageMaxRatio())	{
				// Run time reached average duration, but progress isn't high enough. It might exceed max duration
			}
		}
	}
}
