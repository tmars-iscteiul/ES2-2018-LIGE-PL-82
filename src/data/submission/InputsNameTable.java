package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Names the given variables by the user.
 * @author skner
 *
 */
public class InputsNameTable {
	@JsonProperty("list") private String list;
	@JsonProperty("nameDescription") private String nameDescription;
	
	public InputsNameTable(String list, String description) {
		super();
		this.list = list;
		this.nameDescription = description;
	}
	
	public InputsNameTable() {
		
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getDescription() {
		return nameDescription;
	}

	public void setDescription(String description) {
		this.nameDescription = description;
	}
	
	
}
