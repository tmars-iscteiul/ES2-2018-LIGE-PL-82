package threads;

import utilities.ConsoleLogger;

/**
 * @author skner
 *
 */
public class ProcessManager extends Thread	{
	
	private float progress;	// TODO Find a way to calculate progress (JMetalWorker's Experiments probably)
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
		logger.writeConsoleLog("Process Manager has started, following the " + worker.getProblem().getIntroduction().getName() + "'s worker.");
	}
	
	@Override
	public synchronized void run()	{
		while(worker.isAlive())	{
			checkProgress();
			checkMaxTimeLimit();
			try {
				sleep(updateTimer * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private double getRunTime()	{
		return System.currentTimeMillis() - startTime;
	}
	
	private double getProblemAverageMaxRatio()	{
		return (worker.getProblem().getIntroduction().getAverageDuration().getValue("ms")/worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"));
	}
	
	private void checkProgress()	{
		// TODO
	}

	private void checkMaxTimeLimit()	{
		if(getRunTime() > worker.getProblem().getIntroduction().getMaxDuration().getValue("ms"))	{
			// TODO: Time limit exceeded
		}
		
		if(getRunTime() > worker.getProblem().getIntroduction().getAverageDuration().getValue("ms"))	{
			// TODO: Check if time MIGHT exceed max
			if(progress < getProblemAverageMaxRatio())	{
				// Run time reached average duration, but progress isn't high enough. It might exceed max duration
			}
		}
	}
}
