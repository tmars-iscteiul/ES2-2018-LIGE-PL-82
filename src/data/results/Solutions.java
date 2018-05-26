package data.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Solutions {
	@JsonProperty("problemName") private String problemName;
	@JsonProperty("problemDescription") private String problemDescription;
	@JsonProperty("userEmail") private String userEmail;
	@JsonProperty("outputsFunction") private String outputsFunction;
	@JsonProperty("solutionVariablesNumber") private int solutionVariablesNumber;
	@JsonProperty("processTime") private int processTime;
	@JsonProperty("optimizationDate") private String optimizationDate;
}
