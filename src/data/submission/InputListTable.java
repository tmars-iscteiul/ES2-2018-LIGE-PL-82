package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputListTable {
	@JsonProperty("listName") private String listName;
	@JsonProperty("type") private String type;
	@JsonProperty("numberVar") private int numberVar;
	@JsonProperty("minValue") private double minValue;
	@JsonProperty("maxValue") private double maxValue;
	@JsonProperty("description") private String description;
	
	
	public InputListTable(String listName, String type, int numberVar, double minValue, double maxValue, String description) {
		super();
		this.listName = listName;
		this.type = type;
		this.numberVar = numberVar;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.description = description;
	}
	
	public InputListTable() {
		
	}


	public String getListName() {
		return listName;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNumberVar() {
		return numberVar;
	}


	public void setNumberVar(int numberVar) {
		this.numberVar = numberVar;
	}


	public double getMinValue() {
		return minValue;
	}


	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}


	public double getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
