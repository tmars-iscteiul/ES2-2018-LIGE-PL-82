package data.submission;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Holds all the configuration and algorithm settings and values.
 * @author skner
 *
 */
public class Inputs {
	@JsonProperty("inputListTable") private List<InputListTable> inputListTable;
	@JsonProperty("createInputItems") private CreateInputItems createInputItems;
	@JsonProperty("restrictions") private Restrictions restrictions;
	
	public Inputs(List<InputListTable> inputListTable, CreateInputItems createInputItems, Restrictions restrictions) {
		super();
		this.inputListTable = inputListTable;
		this.createInputItems = createInputItems;
		this.restrictions = restrictions;
	}
	
	public Inputs() {
		
	}

	public List<InputListTable> getInputListTable() {
		return inputListTable;
	}

	public void setInputListTable(List<InputListTable> inputListTable) {
		this.inputListTable = inputListTable;
	}

	public CreateInputItems getCreateInputItems() {
		return createInputItems;
	}

	public void setCreateInputItems(CreateInputItems createInputItems) {
		this.createInputItems = createInputItems;
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}
	
	
}
