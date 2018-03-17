package data;

public class StringVariable extends Variable {

	private String value;	/** Value for the variable as String*/

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

	// FIND A WAY TO GET IT DONE THROUGH THE VARIABLE SUPERCLASS, USING AN INTERFACE TO IMPLEMENT THE VARIABLE TYPE CONSISTENCY
	private void setValue(String value)	{
		this.value = value;
	}

}
