package data.problem;

import utilities.TimeVariable;

/**
 * This class will hold basic information about the problem, such as its defining name or the email from the user. 
 * Will also contain time variables that define the average and max duration for the computing process.
 * 
 * @see Problem
 * @author skner
 *
 */
public class ProblemIntroduction {

	
	private String name;
	private String fullDescription;
	private TimeVariable averageDuration;
	private TimeVariable maxDuration;
	private String userEmail;
	
	public ProblemIntroduction(String name, String fullDescription, TimeVariable averageDuration, TimeVariable maxDuration, String userEmail)	{
		this.name = name;
		this.fullDescription = fullDescription;
		this.averageDuration = averageDuration;
		this.maxDuration = maxDuration;
		this.userEmail = userEmail;
	}
	
	public ProblemIntroduction(data.submission.MainInformation mainInformation)	{
		name = mainInformation.getProblemName();
		fullDescription = mainInformation.getFullDescription();
		userEmail = mainInformation.getUserEmail();
		averageDuration = new TimeVariable(mainInformation.getAverageDuration(), mainInformation.getAverageScale());
		maxDuration = new TimeVariable(mainInformation.getMaxDuration(), mainInformation.getMaxScale());
	}
}
