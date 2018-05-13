package data.submission;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author skner
 *
 */
public class Submission implements Serializable	{

	/*
	 * 	Submission {
	 * 		Introduction {}
	 * 		MainInformation {name, fullDescription, averageDuration, averageScale, maxDuration, maxScale, userEmail}
	 * 		Inputs {
	 * 			input-list-table [{list-name, type, number-var, min-value, max-value, description}]
	 * 			createInputItems {inputs-name-table[list, description]}
	 * 			restrictions {restrictions-list[variable-name, symbol, value]}
	 * 		}
	 * 		FitnessApp	{
	 * 			fitness-list [{fitness-name, file-url}]
	 * 		}
	 * 		Optimization {optimizersSelection, coralReefOptimization, diferencialEvolution, algorithmsList}
	 * 		Feedback {name, email, subject, emailText}
	 * 		FAQ
	 * 
	 */
	
	private Introduction introduction;
	private MainInformation mainInfo;
	private Inputs inputs;
	private FitnessApp fitnessApp;
	private Optimization optimization;
	private Feedback feedback;
	private Faq faq;
	
	public Submission()	{
		
	}
	
	public Submission(Introduction introduction, MainInformation mainInfo, Inputs inputs, FitnessApp fitnessApp,
			Optimization optimization, Feedback feedback, Faq faq) {
		this.introduction = introduction;
		this.mainInfo = mainInfo;
		this.inputs = inputs;
		this.fitnessApp = fitnessApp;
		this.optimization = optimization;
		this.feedback = feedback;
		this.faq = faq;
	}

	public Introduction getIntroduction() {
		return introduction;
	}

	public void setIntroduction(Introduction introduction) {
		this.introduction = introduction;
	}

	public MainInformation getMainInfo() {
		return mainInfo;
	}

	public void setMainInfo(MainInformation mainInfo) {
		this.mainInfo = mainInfo;
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

	public Faq getFaq() {
		return faq;
	}

	public void setFaq(Faq faq) {
		this.faq = faq;
	}
	
	
}
