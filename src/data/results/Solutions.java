package data.results;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Solutions {
	@JsonProperty("problemName") private String problemName;
	@JsonProperty("problemDescription") private String problemDescription;
	@JsonProperty("userEmail") private String userEmail;
	@JsonProperty("outputsFunction") private String outputsFunction;
	@JsonProperty("solutionVariablesNumber") private int solutionVariablesNumber;
	@JsonProperty("processTime") private int processTime;
	@JsonProperty("optimizationDate") private String optimizationDate;
	@JsonProperty("variablesName") private String[] variablesName;
	@JsonProperty("solutionsList") private List<SolutionsList> solutionsList;
	
	public Solutions() {
		
	}
	
	public Solutions(String problemName, String problemDescription, String userEmail, String outputsFunction,
			int solutionVariablesNumber, int processTime, String optimizationDate, String[] variablesName,
			List<SolutionsList> solutionsList) {
		super();
		this.problemName = problemName;
		this.problemDescription = problemDescription;
		this.userEmail = userEmail;
		this.outputsFunction = outputsFunction;
		this.solutionVariablesNumber = solutionVariablesNumber;
		this.processTime = processTime;
		this.optimizationDate = optimizationDate;
		this.variablesName = variablesName;
		this.solutionsList = solutionsList;
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
	public int getSolutionVariablesNumber() {
		return solutionVariablesNumber;
	}
	public void setSolutionVariablesNumber(int solutionVariablesNumber) {
		this.solutionVariablesNumber = solutionVariablesNumber;
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
	public String[] getVariablesName() {
		return variablesName;
	}
	public void setVariablesName(String[] variablesName) {
		this.variablesName = variablesName;
	}
	public List<SolutionsList> getSolutionsList() {
		return solutionsList;
	}
	public void setSolutionsList(List<SolutionsList> solutionsList) {
		this.solutionsList = solutionsList;
	}
	
	
}
