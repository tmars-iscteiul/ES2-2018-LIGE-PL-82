package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class InputListTable {

	/*
	 * input-list-table [{list-name, type, number-var, min-value, max-value, description}]
	 */
	@JsonProperty("list-name")private String listName;
	@JsonProperty("type")private String type;
	@JsonProperty("number-var")private int varNumber;
	@JsonProperty("min-value")private double minValue;
	@JsonProperty("max-value")private double maxValue;
	@JsonProperty("description")private String description;
	
	public InputListTable()	{
	}
	
	public InputListTable(String listName, String type, int varNumber, double minValue, double maxValue,
			String description) {
		super();
		this.listName = listName;
		this.type = type;
		this.varNumber = varNumber;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.description = description;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	
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

	public int getVarNumber() {
		return varNumber;
	}

	public void setVarNumber(int varNumber) {
		this.varNumber = varNumber;
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
