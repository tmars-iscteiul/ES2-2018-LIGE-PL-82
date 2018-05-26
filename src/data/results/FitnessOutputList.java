package data.results;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessOutputList {
	@JsonProperty("label") private String label;
	@JsonProperty("data") private List<Data> data;
	
	public FitnessOutputList() {

	}
	
	public FitnessOutputList(String label, List<Data> data) {
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
	
	public List<Data> getData() {
		return data;
	}
	
	public void setData(List<Data> data) {
		this.data = data;
	}
	
}
