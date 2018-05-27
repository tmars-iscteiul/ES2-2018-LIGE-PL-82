package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Problem name. Spring boot support class
 * @author skner
 *
 */
public class ProblemName {
	@JsonProperty("problemName") private String problemName;

	public ProblemName() {
		
	}
	
	public ProblemName(String problemName) {
		super();
		this.problemName = problemName;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	
	
}
