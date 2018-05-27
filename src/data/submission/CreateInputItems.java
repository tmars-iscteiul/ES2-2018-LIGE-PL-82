package data.submission;

import java.util.List;

/**
 * Submission class from user. Holds configuration inputs.
 * @author skner
 *
 */
public class CreateInputItems {
	private List<InputsNameTable> inputsNameTable;

	public CreateInputItems() {
		super();
	}

	public CreateInputItems(List<InputsNameTable> inputsNameTable) {
		super();
		this.inputsNameTable = inputsNameTable;
	}

	public List<InputsNameTable> getInputsNameTable() {
		return inputsNameTable;
	}

	public void setInputsNameTable(List<InputsNameTable> inputsNameTable) {
		this.inputsNameTable = inputsNameTable;
	}
	
	
}
