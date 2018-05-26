package data.results;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessOutputList {
	@JsonProperty("label") private String label;
	@JsonProperty("data") private double[] data;
	
	public FitnessOutputList() {

	}
	
	public FitnessOutputList(String label, double[] data) {
		super();
		this.label = label;
		this.data = data;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public double[] getData() {
		return data;
	}
	
	public void setData(double[] data) {
		this.data = data;
	}
	
}
