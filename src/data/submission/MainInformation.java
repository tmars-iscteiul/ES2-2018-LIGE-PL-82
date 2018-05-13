package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class MainInformation {
	/*
	 * MainInformation {name, fullDescription, averageDuration, averageScale, maxDuration, maxScale, userEmail}
	 */

	@JsonProperty("name")private String name;
	@JsonProperty("averageDuration")private int averageDuration;
	@JsonProperty("averageScale")private String averageScale;
	@JsonProperty("maxDuration")private int maxDuration;
	@JsonProperty("maxScale")private String maxScale;
	@JsonProperty("fullDescription")private String fullDescription;
	@JsonProperty("userEmail")private String userEmail;
	
	public MainInformation()	{
	}
	
	public MainInformation(String name, int averageDuration, String averageScale, int maxDuration, String maxScale,
			String fullDescription, String userEmail) {
		this.name = name;
		this.averageDuration = averageDuration;
		this.averageScale = averageScale;
		this.maxDuration = maxDuration;
		this.maxScale = maxScale;
		this.fullDescription = fullDescription;
		this.userEmail = userEmail;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
