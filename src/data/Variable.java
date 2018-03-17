package data;

public class Variable {
	
	private String name;	/** Name of the variable*/
	
	private float upperLimit;	/** Upper bound for the float value*/
	private float lowerLimit;	/** Lower bound for the float value*/
	//private ArrayList<String> restrictions;

	public Variable(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the bounds of the value variable. 
	 * The end points are included in the value intervals [lowerLimit, upperLimit]
	 * @param low The lower limit
	 * @param up The upper limit
	 */
	public void setLimits(float low, float up)	{
		lowerLimit = low;
		upperLimit = up;
	}
	
}
