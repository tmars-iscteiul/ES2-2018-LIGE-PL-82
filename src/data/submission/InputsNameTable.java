package data.submission;

import com.fasterxml.jackson.annotation.JsonProperty;

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
