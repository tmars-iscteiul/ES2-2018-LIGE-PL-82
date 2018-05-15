package data;

import data.utils.VariableType;

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
	
	private double upperLimit;	/** Upper bound for the float value*/
	private double lowerLimit;	/** Lower bound for the float value*/
	private VariableType varType; /** Helper to verify the object type, if defined */
	private Object[] valueArray; /** Defined as Object, since we can have multiple values there. To be tweaked in case of non compatibility */

	public Configuration(String name, double low, double up, String type, int configSize) {
		this.name = name;
		setLimits(low, up);
		setArrayType(type);
		valueArray = new Object[configSize];
	}

	/**
	 * Sets the bounds of the value variable. 
	 * The end points are included in the value intervals [lowerLimit, upperLimit]
	 * @param low The lower limit
	 * @param up The upper limit
	 */
	public void setLimits(double low, double up)	{
		lowerLimit = low;
		upperLimit = up;
	}
	
	private void setArrayType(String type) {
		if(type == "int")
			varType = VariableType.varInt;
		else if(type == "double")	
			varType = VariableType.varDouble;
		else if(type == "boolean")	
			varType = VariableType.varBoolean;
		else
			varType = VariableType.varUndefined;
	}
	
	public Object[] getValueArray()	{
		return valueArray;
	}
	
}






