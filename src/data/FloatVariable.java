package data;

public class FloatVariable extends Variable {

	
	/**
	 * Constructor
	 * @param name Name of the variable
	 * @param value Float value associated with the variable
	 */
	public FloatVariable(String name, float value, float up, float low) {
		super(name);
		setValue(value);
		setLimits(up, low);
	}

}
