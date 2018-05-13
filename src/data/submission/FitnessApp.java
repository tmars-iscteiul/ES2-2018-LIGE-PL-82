package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class FitnessApp {
	
	/*
	 * 		FitnessApp	{
	 * 			fitness-list [{fitness-name, file-url}]
	 * 		}
	 */
	
	public class FitnessList	{
		@JsonProperty("fitness-name")private String fitnessName;
		@JsonProperty("file-url")private long url;
		public FitnessList()	{}
		public FitnessList(String fitnessName, long url) {
			super();
			this.fitnessName = fitnessName;
			this.url = url;
		}
		public String getFitnessName() {return fitnessName;}
		public long getUrl() {return url;}
		public void setFitnessName(String fitnessName) {this.fitnessName = fitnessName;}
		public void setUrl(long url) {this.url = url;}
	}
	
	@JsonProperty("fitness-list")private FitnessList fitnessList;

	public FitnessApp()	{
	}
	
	public FitnessApp(FitnessList fitnessList) {
		super();
		this.fitnessList = fitnessList;
	}

	public FitnessList getFitnessList() {
		return fitnessList;
	}

	public void setFitnessList(FitnessList fitnessList) {
		this.fitnessList = fitnessList;
	}
	
	
}

