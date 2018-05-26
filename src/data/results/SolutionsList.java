package data.results;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolutionsList {
	@JsonProperty("label") private String label;
	@JsonProperty("values") private double[] values;
	
	public SolutionsList() {
		
	}
	
	public SolutionsList(String label, double[] values) {
		super();
		this.label = label;
		this.values = values;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double[] getValues() {
		return values;
	}
	public void setValues(double[] values) {
		this.values = values;
	}
	
	
}
