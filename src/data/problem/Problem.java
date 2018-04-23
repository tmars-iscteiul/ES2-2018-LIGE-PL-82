package data.problem;

import java.util.ArrayList;

import data.Variable;
import stakeholders.User;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class Problem {
	//Class attributes must be determined from .JSON file with the problem defined by the user
	
	private User user;
	private String name;
	private String description;
	private Date timeLimit;
	private Date timeIdeal;
	private ArrayList<Variable> variableList;
	
	/*
	 * introduction
	 * - main information {name, fullDescription, averageDuration, averageScale, maxDuration, maxScale, userEmail}
	 * 
	 * inputs
	 * - undefined {list-name, type, number-var, min-value, max-value, description}
	 * - createInputItems {list, description}
	 * - restrictions {variable-name, symbol, value}
	 * 
	 * fitness-app {fitness-name, file-url}
	 * 
	 * optimization {optimizersSelection(enum?), coralReefOptimization, diferencialEvolution, listOfAlgorithms(...)}
	 * 
	 * feedback {name, email, subject, emailText}
	 * 
	 * faqs {}
	 *  
	 */
	
	
	public void load_problem (String file) {
		
	}
}
