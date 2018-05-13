package data.problem.temp;

import java.util.List;

public class FitnessApp {
	private List<FitnessList> fitnessList;

	public FitnessApp(List<FitnessList> fitnessList) {
		super();
		this.fitnessList = fitnessList;
	}

	public List<FitnessList> getFitnessList() {
		return fitnessList;
	}

	public void setFitnessList(List<FitnessList> fitnessList) {
		this.fitnessList = fitnessList;
	}
	
	
}
