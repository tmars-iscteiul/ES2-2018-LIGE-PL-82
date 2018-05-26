package data.jmetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*  NMMin.jar o */

@SuppressWarnings("serial")
public class MyProblemIntegerExternalViaJAR extends AbstractIntegerProblem {
	
	private String jarPath;
	private int calculatedConfigurations;
	  	
	
	  public MyProblemIntegerExternalViaJAR(Integer numberOfVariables, Integer numberOfObjetives,double  minValue, double maxValue, String problemName , String jarPath) {
			this.jarPath= jarPath;
			calculatedConfigurations = 0;
		    setNumberOfVariables(numberOfVariables);
		    setNumberOfObjectives(numberOfObjetives);
		    setName(problemName);

	    List<Integer> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Integer> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add((int)minValue);
	      upperLimit.add((int)maxValue);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);

	  }

	  public void evaluate(IntegerSolution solution){
	    String solutionString ="";
	    String evaluationResultString ="";
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      solutionString = solutionString + " " + solution.getVariableValue(i);  
	    }
	    try {
			String line;
	    	Process p = Runtime.getRuntime().exec("java -jar "+jarPath + " " + solutionString);
	    	BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line = brinput.readLine()) != null) 
	    		{evaluationResultString+=line;}
	    	brinput.close();
	        p.waitFor();
	      }
	      catch (Exception err) { err.printStackTrace(); }
	    
   		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
	    // It is assumed that all evaluated criteria are returned in the same result string
	    for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
		    solution.setObjective(i, Integer.parseInt(individualEvaluationCriteria[i]));    
	    }
	    calculatedConfigurations++;
	  }
	  public int getCalculatedConfigurations()	{
			return calculatedConfigurations;
		}
	}
