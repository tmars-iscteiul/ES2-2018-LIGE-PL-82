package data.results;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
	@JsonProperty("problemName") private String problemName;
	@JsonProperty("problemDescription") private String problemDescription;
	@JsonProperty("userEmail") private String userEmail;
	@JsonProperty("outputsFunction") private String outputsFunction;
	@JsonProperty("solutionVariablesNumber") private int solutionVariablesNumber;
	@JsonProperty("processTime") private int processTime;
	@JsonProperty("optimizationDate") private String optimizationDate;
	@JsonProperty("labels") private String[] labels;
	@JsonProperty("fitnessOutputList") private List<FitnessOutputList> fitnessOutputList;
	
	public Results() {

	}

	public Results(String problemName, String problemDescription, String userEmail, String outputsFunction,
			int solutionVariablesNumber, int processTime, String[] labels, String optimizationDate,
			List<FitnessOutputList> fitnessOutputList) {
		super();
		this.problemName = problemName;
		this.problemDescription = problemDescription;
		this.userEmail = userEmail;
		this.outputsFunction = outputsFunction;
		this.labels = labels;
		this.optimizationDate = optimizationDate;
		this.fitnessOutputList = fitnessOutputList;
		this.solutionVariablesNumber = solutionVariablesNumber;
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
	public List<FitnessOutputList> getFitnessOutputList() {
		return fitnessOutputList;
	}
	public void setFitnessOutputList(List<FitnessOutputList> fitnessOutputList) {
		this.fitnessOutputList = fitnessOutputList;
	}

	public int getSolutionVariablesNumber() {
		return solutionVariablesNumber;
	}

	public void setSolutionVariblesNumber(int solutionVariblesNumber) {
		this.solutionVariablesNumber = solutionVariblesNumber;
	}

	public int getProcessTime() {
		return processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}

	public String getOptimizationDate() {
		return optimizationDate;
	}

	public void setOptimizationDate(String optimizationDate) {
		this.optimizationDate = optimizationDate;
	}

	public void setSolutionVariablesNumber(int solutionVariablesNumber) {
		this.solutionVariablesNumber = solutionVariablesNumber;
	}
	
	
}
