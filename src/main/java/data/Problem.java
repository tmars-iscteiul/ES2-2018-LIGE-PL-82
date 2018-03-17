package data;

import java.util.ArrayList;

import stakeholders.User;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class Problem {
	//Class atributes must be determined from .xml file with the problem defined by the user
	private User user;
	private String name;
	private String description;
	private Date timeLimit;
	private Date timeIdeal;
	private ArrayList<Variable> variableList;
	
	public void load_problem (String file) {
		
	}
}
