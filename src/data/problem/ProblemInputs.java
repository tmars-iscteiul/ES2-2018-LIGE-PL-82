package data.problem;

import java.util.ArrayList;

import data.*;

/**
 * ProblemInputs will contain the inputs for the problem. It will be the most important class that the Jmetalhandler will work with.
 * This class contains all the information necessary for the algorithms to run, including lists rules and restrictions.
 * 
 * @author skner
 *
 */
public class ProblemInputs {

	/*
	 * inputs
	 * - undefined {list-name, type, number-var, min-value, max-value, description}
	 * - createInputItems {list, description} TODO
	 * - restrictions {variable-name, symbol, value} Done, but don't understand how it will relate to other classes
	 * 
	 */
	
	private ArrayList<Configuration> configList; // Queue?
	private String description;
	private ArrayList<Restriction> restrictionList;
	
	public ProblemInputs(String description)	{
		this.description = description;
	}
	
	public void addRestriction(String variableName, String symbol, int value) {
		restrictionList.add(new Restriction(variableName, symbol, value));
	}
	
	public void addRestriction(Restriction r)	{
		restrictionList.add(r);
	}
	
	public void addConfiguration(String listName, String type, int size, float minValue, float maxValue) {
		configList.add(new Configuration(listName, minValue, maxValue, type, size));
	}
	
	public void addRestriction(Configuration c)	{
		configList.add(c);
	}

	public ArrayList<Configuration> getConfigList() {
		return configList;
	}
	
	

}
