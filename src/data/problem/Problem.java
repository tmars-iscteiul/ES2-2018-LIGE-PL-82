package data.problem;

import data.submission.Submission;

/**
 * The class problem will be the operational class given by the user, made from the submission. 
 * It will then fork into different sections, that will allow the engine to work with each one in a more intuitive way. 
 * The hierarchy will follow the following tree:
 * 
 * - Problem
 * | - @see ProblemIntroduction
 * | - @see ProblemInputs
 * | | - @see Configuration 
 * | | - @see Restriction 
 * | - @see ProblemOptimization
 * | - @see ProblemFitnessApp 
 * 
 * @author skner
 *
 */
public class Problem {

	private ProblemIntroduction introduction;
	private ProblemInputs inputs;
	private ProblemOptimization optimization;
	private ProblemFitnessApp fitnessApp;

	public Problem() {
		//introduction = new ProblemIntroduction("", fullDescription, averageDuration, maxDuration, userEmail)
	}
	
	public Problem(ProblemIntroduction introduction, ProblemInputs inputs, ProblemOptimization optimization, ProblemFitnessApp fitnessApp)	{
		this.introduction = introduction;
		this.inputs = inputs;
		this.optimization = optimization;
		this.fitnessApp = fitnessApp;
	}
	
	public Problem(Submission submission) {
		introduction = new ProblemIntroduction(submission.getMainInformation());
		inputs = new ProblemInputs(submission.getInputs());
		optimization = new ProblemOptimization(submission.getOptimization());
		// Why is submission.fitnessApp a list? Does it contain various fitness apps, all for the same problem, but for different input lists?
		// For now, I'm assuming this isn't true, and checking only the first member of the list. TODO Possible change 
		fitnessApp = new ProblemFitnessApp(submission.getFitnessApp());
		
	}

	/*
	 * SETTERS
	 */
	public void setIntroduction(ProblemIntroduction introduction) {
		this.introduction = introduction;
	}
	
	public void setInputs(ProblemInputs inputs) {
		this.inputs = inputs;
	}

	public void setOptimization(ProblemOptimization optimization)	{
		this.optimization = optimization;
	}

	public void setFitnessApp(ProblemFitnessApp fitnessApp) {
		this.fitnessApp = fitnessApp;
	}

	/*
	 * GETTERS
	 */
	public ProblemIntroduction getIntroduction() {
		return introduction;
	}
	
	public ProblemInputs getInputs() {
		return inputs;
	}

	public ProblemOptimization getOptimization()	{
		return optimization;
	}
	
	public ProblemFitnessApp getFitnessApp() {
		return fitnessApp;
	}

}
