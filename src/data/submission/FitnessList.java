package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessList {
	@JsonProperty("fitnessName") private String fitnessName;
	@JsonProperty("fileURL") private String fileURL;
	
	public FitnessList(String fitnessName, String fileURL) {
		super();
		this.fitnessName = fitnessName;
		this.fileURL = fileURL;
	}

	public FitnessList() {
		
	}
	
	public String getFitnessName() {
		return fitnessName;
	}

	public void setFitnessName(String fitnessName) {
		this.fitnessName = fitnessName;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	
	
}
