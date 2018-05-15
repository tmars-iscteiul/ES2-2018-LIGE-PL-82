package data;

/**
 * Restrictions mean that in a linked configuration, no slot can ignore the restriction. 
 * 
 * @author skner
 *
 */
public class Restriction {

	/*
	 * restrictions {variable-name, symbol, value}
	 */
	
	private String variableName;
	private String symbol;
	private int value;
	
	public Restriction(String variableName, String symbol, int value)	{
		this.variableName = variableName;
		this.symbol = symbol;
		this.value = value;
	}
}
