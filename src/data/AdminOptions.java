package data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that will hold information imported from config.json, that will configure general settings for the software.
 * @author skner
 *
 */
public class AdminOptions {

	@JsonProperty("admin-name")private String adminName;
	@JsonProperty("admin-email")private String adminEmail;
	@JsonProperty("independent-runs")private int independentRuns;
	@JsonProperty("max-evaluations")private int maxEvaluations;
	@JsonProperty("population-size")private int populationSize;

	public AdminOptions()	{
	}
	
	public AdminOptions(String adminName, String adminEmail, int independentRuns, int maxEvaluations, int populationSize) {
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.independentRuns = independentRuns;
		this.maxEvaluations = maxEvaluations;
		this.populationSize = populationSize;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public int getIndependentRuns() {
		return independentRuns;
	}

	public void setIndependentRuns(int independentRuns) {
		this.independentRuns = independentRuns;
	}

	public int getMaxEvaluations() {
		return maxEvaluations;
	}

	public void setMaxEvaluations(int maxEvaluations) {
		this.maxEvaluations = maxEvaluations;
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	@Override
	public String toString() {
		return "AdminOptions [adminName=" + adminName + ", adminEmail=" + adminEmail + ", independentRuns="
				+ independentRuns + ", maxEvaluations=" + maxEvaluations + ", populationSize=" + populationSize + "]";
	}
	
	
	
}
