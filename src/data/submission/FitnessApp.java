package data.submission;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessApp {
	@JsonProperty("fitnessOutputList") private List<FitnessOutputList> fitnessOutputList;
	@JsonProperty("fitnessName") private String fitnessName;
	@JsonProperty("fileURL") private String fileURL;

	public FitnessApp(List<FitnessOutputList> fitnessOutputList, String fitnessName, String fileURL) {
		super();
		this.fitnessOutputList = fitnessOutputList;
		this.fitnessName = fitnessName;
		this.fileURL = fileURL;
	}

	public FitnessApp() {
		
	}
	
	public List<FitnessOutputList> getFitnessOutputList() {
		return fitnessOutputList;
	}

	public void setFitnessOutputList(List<FitnessOutputList> fitnessOutputList) {
		this.fitnessOutputList = fitnessOutputList;
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
