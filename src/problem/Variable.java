package problem;

import java.util.ArrayList;

public class Variable {
	
	private String name;
	private int intValue;
	private String stringValue;
	private double limitSuperior;
	private double limitInferior;
	private ArrayList<String> restrictions;
	//add more variable types as needed, which variable type has to have a constructor
	
	public Variable(String name, String value) {
		this.name = name;
		stringValue = value;
	}
	
	public Variable(String name, int value, double limitSuperior, double limitInferior) {
		this.name = name;
		intValue = value;
		this.limitSuperior = limitSuperior;
		this.limitInferior = limitInferior;
	}
	
	
}
