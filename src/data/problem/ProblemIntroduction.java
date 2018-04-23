package data.problem;

import utils.TimeVariable;

public class ProblemIntroduction {

	/*
	 * introduction
	 * - main information {name, fullDescription, averageDuration, averageScale, maxDuration, maxScale, userEmail}
	 */
	
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
	
}
