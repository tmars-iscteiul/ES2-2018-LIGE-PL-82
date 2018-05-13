package data.problem.temp;

public class Problem {
	private Introduction introduction;
	private MainInformation mainInformation;
	private Inputs inputs;
	private FitnessApp fitnessApp;
	private Optimization optimization;
	private Feedback feedback;
	private Faqs faqs;

	public Problem()	{
		this.introduction = null;
		this.mainInformation = null;
		this.inputs = null;
		this.optimization = null;
		this.fitnessApp = null;
		this.feedback = null;
		this.faqs = null;
	}
	
	public Problem(Introduction introduction,
			MainInformation mainInformation,
			Inputs inputs,
			FitnessApp fitnessApp,
			Optimization optimization,
			Feedback feedback,
			Faqs faqs)	{
		this.introduction = introduction;
		this.inputs = inputs;
		this.optimization = optimization;
		this.fitnessApp = fitnessApp;
		this.feedback = feedback;
		this.faqs = faqs;
	}
}
