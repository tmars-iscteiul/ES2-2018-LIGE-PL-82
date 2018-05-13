package data.problem.temp;

public class FitnessList {
	private String fitnessName;
	private String fileURL;
	
	public FitnessList(String fitnessName, String fileURL) {
		super();
		this.fitnessName = fitnessName;
		this.fileURL = fileURL;
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
