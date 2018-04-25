package data.problem;

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
 * | - @see ProblemFitnessApp TODO: Still unknown how we'll implement this. What link can we use? How do we download the .jar file? ...
 * | - @see ProblemFeedback
 * 
 * 
 * @author skner
 *
 */
public class Problem {
	//Class attributes must be determined from .JSON file with the problem defined by the user
	
	private ProblemIntroduction introduction;
	private ProblemInputs inputs;
	private ProblemFitnessApp fitnessApp;
	private ProblemFeedback feedback;

	public Problem()	{
		this.introduction = null;
		this.inputs = null;
		this.fitnessApp = null;
		this.feedback = null;
	}
	
	public Problem(ProblemIntroduction introduction, ProblemInputs inputs, ProblemFitnessApp fitnessApp, ProblemFeedback feedback)	{
		this.introduction = introduction;
		this.inputs = inputs;
		this.fitnessApp = fitnessApp;
		this.feedback = feedback;
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


	public void setFitnessApp(ProblemFitnessApp fitnessApp) {
		this.fitnessApp = fitnessApp;
	}

	public void setFeedback(ProblemFeedback feedback) {
		this.feedback = feedback;
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

	public ProblemFitnessApp getFitnessApp() {
		return fitnessApp;
	}

	public ProblemFeedback getFeedback() {
		return feedback;
	}	
	
}
