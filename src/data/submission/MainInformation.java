package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Holds basic general information about the user and the problem.
 * @author skner
 *
 */
public class MainInformation {
	@JsonProperty("problemName") private String problemName;
	@JsonProperty("fullDescription") private String fullDescription;
	@JsonProperty("averageDuration") private int averageDuration;
	@JsonProperty("averageScale") private String averageScale;
	@JsonProperty("maxDuration") private int maxDuration;
	@JsonProperty("maxScale") private String maxScale;
	@JsonProperty("userEmail") private String userEmail;
	
	public MainInformation(String problemName, String fullDescription, int averageDuration, String averageScale,
			int maxDuration, String maxScale, String userEmail) {
		super();
		this.problemName = problemName;
		this.fullDescription = fullDescription;
		this.averageDuration = averageDuration;
		this.averageScale = averageScale;
		this.maxDuration = maxDuration;
		this.maxScale = maxScale;
		this.userEmail = userEmail;
	}
	
	public MainInformation() {
		
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public int getAverageDuration() {
		return averageDuration;
	}

	public void setAverageDuration(int averageDuration) {
		this.averageDuration = averageDuration;
	}

	public String getAverageScale() {
		return averageScale;
	}

	public void setAverageScale(String averageScale) {
		this.averageScale = averageScale;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public String getMaxScale() {
		return maxScale;
	}

	public void setMaxScale(String maxScale) {
		this.maxScale = maxScale;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
