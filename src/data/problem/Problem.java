package data.problem;

import data.submission.Submission;

/**
 * The class problem will be the entire submission from the user. It will then fork into different sections, that will allow the engine to work
 * with each one in a more intuitive way. 
 * The hierarchy will follow the following tree:
 * 
 * Problem
 * | - @see ProblemIntroduction
 * | - @see ProblemInputs
 * | | - @see Configuration 
 * | | - @see * 
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

	public Problem(ProblemIntroduction introduction, ProblemInputs inputs, ProblemOptimization optimization, 
			ProblemFitnessApp fitnessApp)	{
		this.introduction = introduction;
		this.inputs = inputs;
		this.optimization = optimization;
		this.fitnessApp = fitnessApp;
	}
	
	public Problem(Submission submission) {
		introduction = new ProblemIntroduction(submission.getMainInformation());
		inputs = new ProblemInputs(submission.getInputs());
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
