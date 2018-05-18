package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class will be called by every single operating entity on the software, to write console logs.
 * Using this class, we can define a string structure that will be consistent for every message.
 * @author skner
 *
 */
public class ConsoleLogger {
	
	private String systemTag;
	private DateTimeFormatter dtf;
	
	public ConsoleLogger(String tag)	{
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

		systemTag = tag;
	}
	
	public void writeConsoleLog(String message)	{
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now) + "  [" + systemTag + "] " + message);
	}
	
	public void writeFileLog(String message)	{
		// POSSIBLE TODO
	}
}
