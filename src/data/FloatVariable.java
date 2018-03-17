package data;

public class FloatVariable extends Variable {

	private float value;	/** Value for the variable as Float*/
	
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

	// FIND A WAY TO GET IT DONE THROUGH THE VARIABLE SUPERCLASS, USING AN INTERFACE TO IMPLEMENT THE VARIABLE TYPE CONSISTENCY
	private void setValue(float value)	{
		this.value = value;
	}
}
