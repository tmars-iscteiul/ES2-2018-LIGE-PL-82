package data;

public class IntegerValue extends Variable {
	
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

}
