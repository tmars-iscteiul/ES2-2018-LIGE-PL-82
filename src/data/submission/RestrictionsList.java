package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Holds restrictions, to be used by @see Restriction.
 * @author skner
 *
 */
public class RestrictionsList {
	@JsonProperty("variableName") private String variableName;
	@JsonProperty("symbol") private String symbol;
	@JsonProperty("value") private Double value;
	
	public RestrictionsList(String variableName, String symbol, Double value) {
		super();
		this.variableName = variableName;
		this.symbol = symbol;
		this.value = value;
	}
	
	public RestrictionsList() {
		
	}

	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
