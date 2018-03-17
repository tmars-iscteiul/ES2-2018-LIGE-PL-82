package data;

public class IntegerValue extends Variable {
	
	private int value;	/** Value for the variable as Integer*/
	
	/**
	 * Constructor
	 * @param name Name of the variable
	 * @param value Integer value associated with the variable
	 */
	public IntegerValue(String name, int value, float up, float low) {
		super(name);
		setValue(value);
		setLimits(up, low);
	}

	// FIND A WAY TO GET IT DONE THROUGH THE VARIABLE SUPERCLASS, USING AN INTERFACE TO IMPLEMENT THE VARIABLE TYPE CONSISTENCY
	private void setValue(int value)	{
		this.value = value;
	}
}