package data.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	@JsonProperty("problemName") private String problemName;
	@JsonProperty("problemDescription") private String problemDescription;
	@JsonProperty("userEmail") private String userEmail;
	@JsonProperty("outputsFunction") private String outputsFunction;
	@JsonProperty("solutionVariablesNumber") private int solutionVariblesNumber;
	@JsonProperty("processTime") private int processTime;
	@JsonProperty("labels") private String[] labels;
	@JsonProperty("bestAlgorithm") private String bestAlgorithm;
	@JsonProperty("fitnessOutputList") private FitnessOutputList fitnessOutputList;
	
	public Results() {

	}

	public Results(String problemName, String problemDescription, String userEmail, String outputsFunction,
			int solutionVariablesNumber, int processTime, String[] labels, String bestAlgorithm, 
			FitnessOutputList fitnessOutputList) {
		super();
		this.problemName = problemName;
		this.problemDescription = problemDescription;
		this.userEmail = userEmail;
		this.outputsFunction = outputsFunction;
		this.labels = labels;
		this.bestAlgorithm = bestAlgorithm;
		this.fitnessOutputList = fitnessOutputList;
		this.solutionVariblesNumber = solutionVariablesNumber;
		this.processTime = processTime;
	}
	
	
	public String getProblemName() {
		return problemName;
	}
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOutputsFunction() {
		return outputsFunction;
	}
	public void setOutputsFunction(String outputsFunction) {
		this.outputsFunction = outputsFunction;
	}
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public String getBestAlgorithm() {
		return bestAlgorithm;
	}
	public void setBestAlgorithm(String bestAlgorithm) {
		this.bestAlgorithm = bestAlgorithm;
	}
	public FitnessOutputList getFitnessOutputList() {
		return fitnessOutputList;
	}
	public void setFitnessOutputList(FitnessOutputList fitnessOutputList) {
		this.fitnessOutputList = fitnessOutputList;
	}

	public int getSolutionVariblesNumber() {
		return solutionVariblesNumber;
	}

	public void setSolutionVariblesNumber(int solutionVariblesNumber) {
		this.solutionVariblesNumber = solutionVariblesNumber;
	}

	public int getProcessTime() {
		return processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}
	
	
}
