package data.jmetal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import data.problem.Configuration;
import data.problem.ProblemInputs;
import threads.JMetalWorker;

/* Kursawe.jar  */

@SuppressWarnings("serial")
public class MyProblemDoubleExternalViaJAR extends AbstractDoubleProblem {
	/*
	  public MyProblemDoubleExternalViaJAR() {
	    // 10 variables (anti-spam filter rules) by default 
	    this(10);
	  }*/
	  private String jarPath;
	  
	  public MyProblemDoubleExternalViaJAR(
			  Integer numberOfVariables, Integer numberOfObjetives, Double minValue, Double maxValue, String problemName , String jarPath) {
		this.jarPath= jarPath;
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(numberOfObjetives);
	    setName(problemName);

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(minValue);
	      upperLimit.add(maxValue);
	    }
	    
	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);	    	    
	  } 

	  public void evaluate(DoubleSolution solution){
	    String solutionString = "";
	    String evaluationResultString = "";
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	        solutionString += " " + solution.getVariableValue(i);  
	    }
	    try {
			String line;

	    	//Process p = Runtime.getRuntime().exec("java -jar c:\\Kursawe.jar" + " " + solutionString);
			//System.out.println("Sending args to external JAR: " + solutionString);
			Process p = Runtime.getRuntime().exec("java -jar " + jarPath + " " + solutionString);
	    	
	    	
	    	BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    	while ((line = brinput.readLine()) != null) 
	    		{evaluationResultString+=line;}
	    	brinput.close();
	        p.waitFor();
	      }
	      catch (Exception err) { err.printStackTrace(); }
	    //System.out.println("Received results from external JAR: " + evaluationResultString);
   		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
	    // It is assumed that all evaluated criteria are returned in the same result string
	    for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
	    	solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
	    }	    
	  }
	}
