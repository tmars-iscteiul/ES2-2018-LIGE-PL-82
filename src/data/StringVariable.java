package data;

public class StringVariable extends Variable {

	/**
	 * Constructor
	 * @param name Name of the variable
	 * @param value String value associated with the variable
	 */
	public StringVariable(String name, String value, float up, float low) {
		super(name);
		setValue(value);
		setLimits(up, low);
	}

}
