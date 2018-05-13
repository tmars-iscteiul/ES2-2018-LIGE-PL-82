package data.problem.temp;

public class RestrictionsList {
	private String variableName;
	private String symbol;
	private Double value;
	
	public RestrictionsList(String variableName, String symbol, Double value) {
		super();
		this.variableName = variableName;
		this.symbol = symbol;
		this.value = value;
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
