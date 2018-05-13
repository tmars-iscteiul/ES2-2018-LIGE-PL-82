package data.problem.temp;

public class InputListTable {
	private String listName;
	private String type;
	private int numberVar;
	private int minValue;
	private int maxValue;
	private String description;
	
	
	public InputListTable(String listName, String type, int numberVar, int minValue, int maxValue, String description) {
		super();
		this.listName = listName;
		this.type = type;
		this.numberVar = numberVar;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.description = description;
	}


	public String getListName() {
		return listName;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNumberVar() {
		return numberVar;
	}


	public void setNumberVar(int numberVar) {
		this.numberVar = numberVar;
	}


	public int getMinValue() {
		return minValue;
	}


	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}


	public int getMaxValue() {
		return maxValue;
	}


	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
