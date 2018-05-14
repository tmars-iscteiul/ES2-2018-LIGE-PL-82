package data.problem.temp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessApp {
	@JsonProperty("fitnessList") private List<FitnessList> fitnessList;

	public FitnessApp(List<FitnessList> fitnessList) {
		super();
		this.fitnessList = fitnessList;
	}
	
	public FitnessApp() {
		
	}

	public List<FitnessList> getFitnessList() {
		return fitnessList;
	}

	public void setFitnessList(List<FitnessList> fitnessList) {
		this.fitnessList = fitnessList;
	}
	
	
}
