package data.problem;

import data.Configuration;

public class ProblemInputs {

	/*
	 * inputs
	 * - undefined {list-name, type, number-var, min-value, max-value, description}
	 * 
	 */

	private Configuration config;
	private String description;
	
	public ProblemInputs(String listName, String type, int size, float minValue, float maxValue, String description)	{
		if (type == "int")	{
			config = new Configuration(listName, minValue, maxValue, type, size);
			this.description = description;
		}
	}

}
