package data.problem;

/**
 * Restrictions mean that in a linked configuration, no slot can ignore the restriction. 
 * TODO: Perhaps do some sort of automated method so the algorithms can more easily call the restrictions
 *  
 *  @author skner
 *
 */
public class Restriction {

	private String variableName;
	private String symbol;
	private double value;
	
	public Restriction(String variableName, String symbol, double value)	{
		this.variableName = variableName;
		this.symbol = symbol;
		this.value = value;
	}
	
	public Restriction(data.submission.RestrictionsList restriction)	{
		variableName = restriction.getVariableName();
		symbol = restriction.getSymbol();
		value = restriction.getValue(); 
	}
	
}
