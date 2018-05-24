package data.problem;

import java.util.ArrayList;

import data.*;


/**
 * ProblemInputs will contain the inputs for the problem. It will be the most important class that the jmetal handler will work with.
 * This class contains all the information necessary for the algorithms to run, including lists rules and restrictions.
 * 
 * @author skner
 *
 */
public class ProblemInputs {

	private ArrayList<Configuration> configList;
	private ArrayList<Restriction> restrictionList;
	
	public ProblemInputs()	{
		configList = new ArrayList<Configuration>();
		restrictionList = new ArrayList<Restriction>();
	}
	
	public ProblemInputs(data.submission.Inputs inputs) {
		this();
		Configuration configAux;
		for(int i = 0; i<inputs.getInputListTable().size(); i++)	{
			// TODO What type of confirmation do we need to check in order to give names to the variables for each configuration? 
			// The name of the list must match? No check are being made at the moment
			configAux = new Configuration(inputs.getInputListTable().get(i));
			configAux.setVariableNames(inputs.getCreateInputItems().getInputsNameTable().get(i).getDescription());
			configList.add(configAux);
		}
		/*
		for(int i = 0; i<inputs.getRestrictions().getRestrictionsList().size(); i++)	{
			restrictionList.add(new Restriction(inputs.getRestrictions().getRestrictionsList().get(i)));
		}*/
	}

	public void addRestriction(String variableName, String symbol, int value) {
		restrictionList.add(new Restriction(variableName, symbol, value));
	}
	
	public void addRestriction(Restriction r)	{
		restrictionList.add(r);
	}
	
	public void addConfiguration(String listName, double minValue, double maxValue, String type, int size, String description) {
		configList.add(new Configuration(listName, minValue, maxValue, type, size, description));
	}
	
	public void addConfiguration(Configuration c)	{
		configList.add(c);
	}

	public ArrayList<Configuration> getConfigList() {
		return configList;
	}
	
}
