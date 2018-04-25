package data.problem;

import java.util.ArrayList;

import data.Configuration;
import stakeholders.User;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 * The class problem will be the entire submission from the user. It will then fork into different sections, that will allow the engine to work
 * with each one in a more intuitive way. 
 * The hierarchy will follow the following tree:
 * 
 * Problem
 * | - @see ProblemIntroduction
 * | - @see ProblemInputs
 * | | - @see Configuration 
 * | | - @see * 
 * | | - @see Restriction 
 * | - @see ProblemFitnessApp TODO: Still unknown how we'll implement this. What link can we use? How do we download the .jar file? ...
 * | - @see ProblemFeedback
 * 
 * 
 * @author skner
 *
 */
public class Problem {
	//Class attributes must be determined from .JSON file with the problem defined by the user
	
	private User user;
	private String name;
	private String description;
	private Date timeLimit;
	private Date timeIdeal;
	private ArrayList<Configuration> variableList;
	
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
