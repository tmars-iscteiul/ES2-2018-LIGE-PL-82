package data.problem.temp;

import java.util.List;

public class Inputs {
	private List<InputListTable> inputListTable;
	private CreateInputItems createInputItems;
	private Restrictions restrictions;
	
	public Inputs(List<InputListTable> inputListTable, CreateInputItems createInputItems, Restrictions restrictions) {
		super();
		this.inputListTable = inputListTable;
		this.createInputItems = createInputItems;
		this.restrictions = restrictions;
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
