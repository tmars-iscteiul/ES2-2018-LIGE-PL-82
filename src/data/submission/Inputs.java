package data.submission;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class Inputs {

	/*
	 * 		Inputs {
	 * 			input-list-table [{list-name, type, number-var, min-value, max-value, description}]
	 * 			createInputItems {inputs-name-table[list, description]}
	 * 			restrictions {restrictions-list[variable-name, symbol, value]}
	 * 		}
	 */
	
	@JsonProperty("input-list-table")private ArrayList<InputListTable> inputList;
	@JsonProperty("createInputItems")private InputNameTable inputNames;
	@JsonProperty("restriction")private Restrictions restrictionsList;
	
	public Inputs()	{
		
	}
	
	public Inputs(ArrayList<InputListTable> inputList, InputNameTable inputNames, Restrictions restrictionsList) {
		this.inputList = inputList;
		this.inputNames = inputNames;
		this.restrictionsList = restrictionsList;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */

	public ArrayList<InputListTable> getInputList() {
		return inputList;
	}

	public void setInputList(ArrayList<InputListTable> inputList) {
		this.inputList = inputList;
	}

	public InputNameTable getInputNames() {
		return inputNames;
	}

	public void setInputNames(InputNameTable inputNames) {
		this.inputNames = inputNames;
	}

	public Restrictions getRestrictionsList() {
		return restrictionsList;
	}

	public void setRestrictionsList(Restrictions restrictionsList) {
		this.restrictionsList = restrictionsList;
	}
	
	
}
