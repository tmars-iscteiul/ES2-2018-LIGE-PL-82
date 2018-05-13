package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class Restrictions {

	/*
	 * restrictions {restrictions-list[variable-name, symbol, value]}
	 */
	
	public class RestrictionsList {
		@JsonProperty("variable-name")private String variableName;
		@JsonProperty("symbol")private String symbol;
		@JsonProperty("value")private double value;
		public RestrictionsList()	{}
		public RestrictionsList(String variableName, String symbol, double value) {
			this.variableName = variableName;
			this.symbol = symbol;
			this.value = value;
		}
		/*
		 * GETTERS AND SETTERS
		 */
		public String getVariableName() {return variableName;}
		public String getSymbol() {return symbol;}
		public double getValue() {return value;}
		public void setVariableName(String variableName) {this.variableName = variableName;}
		public void setSymbol(String symbol) {this.symbol = symbol;}
		public void setValue(double value) {this.value = value;}
	}
	
	@JsonProperty("restrictions-list")private RestrictionsList restrictionsList;

	public Restrictions()	{
	}
	
	public Restrictions(RestrictionsList restrictionsList) {
		this.restrictionsList = restrictionsList;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public RestrictionsList getRestrictionsList() {
		return restrictionsList;
	}

	public void setRestrictionsList(RestrictionsList restrictionsList) {
		this.restrictionsList = restrictionsList;
	}
	
	
}
