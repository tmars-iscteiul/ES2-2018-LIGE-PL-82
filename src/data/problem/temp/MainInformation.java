package data.problem.temp;

public class MainInformation {
	private String name;
	private String fullDescription;
	private int averageDuration;
	private String averageScale;
	private int maxDuration;
	private String maxScale;
	private String userEmail;
	
	public MainInformation(String name, String fullDescription, int averageDuration, String averageScale,
			int maxDuration, String maxScale, String userEmail) {
		super();
		this.name = name;
		this.fullDescription = fullDescription;
		this.averageDuration = averageDuration;
		this.averageScale = averageScale;
		this.maxDuration = maxDuration;
		this.maxScale = maxScale;
		this.userEmail = userEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
