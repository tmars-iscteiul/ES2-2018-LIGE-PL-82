package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Holds a fitness output list, matching with the evaluators output.
 * @author skner
 *
 */
public class FitnessOutputList {
	@JsonProperty("outputName") private String outputName;
	@JsonProperty("outputType") private String outputType;
	@JsonProperty("outputDescription") private String outputDescription;
	
	public FitnessOutputList(String fitnessName, String fileURL, String outputDescription) {
		super();
		this.outputName = fitnessName;
		this.outputType = fileURL;
		this.outputDescription = outputDescription;
	}

	public FitnessOutputList() {
		
	}
	
	public String getOutputName() {
		return outputName;
	}

	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public String getOutputDescription() {
		return outputDescription;
	}

	public void setOutputDescription(String outputDescription) {
		this.outputDescription = outputDescription;
	}
	
	
}
