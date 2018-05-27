package data.problem;

/**
 * This class will define specific restriction the user wants applied to the algorithms run.
 * Restrictions mean that in a linked configuration, no slot can ignore the restriction. 
 *  @author skner
 *
 */
public class Restriction {

	@SuppressWarnings("unused")
	private String variableName;
	@SuppressWarnings("unused")
	private String symbol;
	@SuppressWarnings("unused")
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
