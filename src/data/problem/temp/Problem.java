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

	public Introduction getIntroduction() {
		return introduction;
	}

	public void setIntroduction(Introduction introduction) {
		this.introduction = introduction;
	}

	public MainInformation getMainInformation() {
		return mainInformation;
	}

	public void setMainInformation(MainInformation mainInformation) {
		this.mainInformation = mainInformation;
	}

	public Inputs getInputs() {
		return inputs;
	}

	public void setInputs(Inputs inputs) {
		this.inputs = inputs;
	}

	public FitnessApp getFitnessApp() {
		return fitnessApp;
	}

	public void setFitnessApp(FitnessApp fitnessApp) {
		this.fitnessApp = fitnessApp;
	}

	public Optimization getOptimization() {
		return optimization;
	}

	public void setOptimization(Optimization optimization) {
		this.optimization = optimization;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Faqs getFaqs() {
		return faqs;
	}

	public void setFaqs(Faqs faqs) {
		this.faqs = faqs;
	}
	
	
}
