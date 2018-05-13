package data.submission;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author skner
 *
 */
public class InputNameTable {

	/*
	 * createInputItems {inputs-name-table[list, description]}
	 */
		
	public class InputNameTableList {
		@JsonProperty("list")private String list;
		@JsonProperty("description")private String description;
		public InputNameTableList()	{}
		public InputNameTableList(String list, String description) {
			this.list = list;
			this.description = description;
		}
		/*
		 * GETTERS AND SETTERS
		 */
		public String getList() {return list;}
		public String getDescription() {return description;}
		public void setList(String list) {this.list = list;}
		public void setDescription(String description) {this.description = description;}
	}
	
	@JsonProperty("inputs-name-table")private ArrayList<InputNameTableList> inputNameList;

	public InputNameTable()	{
	}
	
	public InputNameTable(ArrayList<InputNameTableList> inputNameList) {
		this.inputNameList = inputNameList;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	
	public ArrayList<InputNameTableList> getInputNameList() {
		return inputNameList;
	}

	public void setInputNameList(ArrayList<InputNameTableList> inputNameList) {
		this.inputNameList = inputNameList;
	}
}
