package data.problem;

import utilities.VariableType;

/**
 * The configuration class will hold the important information to be passed to the specified algorithm
 * The valueArray type works by not having a restriction in what value you put it, any object type is valid. However, there's a varType that creates
 * restrictions, when need to be applied. 
 * Possible TODOs:
 * - Create various varType restrictions
 * - Verify compatibility with algorithms
 * 
 * @author skner
 *
 */
public class Configuration {
	
	private String name;	/** Name of the variable*/
	private String description;
	
	private double upperLimitDouble;	/** Upper bound for the float value*/
	private double lowerLimitDouble;	/** Lower bound for the float value*/
	private int upperLimitInteger;	/** Upper bound for the integer value*/
	private int lowerLimitInteger;	/** Lower bound for the integer value*/
	
	private VariableType varType; /** Helper to verify the object type, if defined */
	private String[] valueName;
	private Object[] valueArray; /** Defined as Object, since we can have multiple values there. To be tweaked in case of non compatibility */

	public Configuration(String name, double low, double up, String type, int configSize, String description) {
		this.name = name;
		setDoubleLimits(low, up);
		setArrayType(type);
		valueArray = new Object[configSize];
		valueName = new String[configSize];
		this.description = description;
	}
	public Configuration(String name, int low, int up, String type, int configSize, String description) {
		this.name = name;
		setIntegerLimits(low, up);
		setArrayType(type);
		valueArray = new Object[configSize];
		valueName = new String[configSize];
		this.description = description;
	}

	public Configuration(data.submission.InputListTable input)	{
		name = input.getListName();
		System.out.println("classe Configuration - input.getMinValue / input.getMaxValue ="+ input.getMinValue()+ "/"+ input.getMaxValue());
		setDoubleLimits(input.getMinValue(), input.getMaxValue());// como e que o os gets devolvem um int e a função recebe um double?
		setArrayType(input.getType());
		valueArray = new Object[input.getNumberVar()];
		valueName = new String[input.getNumberVar()];
		description = input.getDescription();
	}
	
	/**
	 * Sets the bounds of the value variable. 
	 * The end points are included in the value intervals [lowerLimit, upperLimit]
	 * @param low The lower limit
	 * @param up The upper limit
	 */
	
	/*
	public void setLimits(double low, double up)	{
		if ( ) {
			
		}else if () {
			
		}
	}*/
	public void setDoubleLimits(double low, double up)	{
		lowerLimitDouble = low;
		upperLimitDouble = up;
	}
	
	public void setIntegerLimits(int low, int up)	{
		lowerLimitInteger = low;
		upperLimitInteger = up;
	}
	
	
	public double getUpperLimitDouble() {
		return upperLimitDouble;
	}

	public double getLowerLimitDouble() {
		return lowerLimitDouble;
	}
	public int getUpperLimitInteger() {
		return upperLimitInteger;
	}

	public int getLowerLimitInteger() {
		return lowerLimitInteger;
	}

	

	public void setArrayType(String type) {
		if(type.equals("int")) {
			varType = VariableType.varInt;
		}
		else if(type.equals("double")) {	
			varType = VariableType.varDouble;
		}
		else if(type.equals("boolean")) {
			varType = VariableType.varBoolean;
		}else {
			varType = VariableType.varUndefined;
		}
	}
	
	

	public Object[] getValueArray()	{
		return valueArray;
	}
	
	public VariableType getVarType() {
		return varType;
	}
	
	public void setVariableNames(String names)	{
		if(names != null)	{
			valueName = names.split(",");
		}
	}

	
}






