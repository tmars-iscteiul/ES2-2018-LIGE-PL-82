package data.jmetal;

import org.uma.jmetal.problem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.impl.DefaultBinarySolution;
import org.uma.jmetal.util.JMetalException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * Class containing binary information for JMetal's algorithms.
 * @author skner
 *
 */
@SuppressWarnings("serial")
public class MyProblemBinaryExternalViaJAR extends AbstractBinaryProblem {
	  private int bits ;
	  private String jarPath;
	  private int calculatedConfigurations;
	  
	  public MyProblemBinaryExternalViaJAR(int numberOfVariables, int nrBits, int numberOfObjetives, String problemName, String jarPath) throws JMetalException{
		  this.jarPath= jarPath;
		  calculatedConfigurations = 0;
		  setNumberOfVariables(numberOfVariables);
		  setNumberOfObjectives(2);
		  setName(problemName);
		  bits= nrBits;
		}

	  @Override
	  protected int getBitsPerVariable(int index) {
	  	return bits ;
	  }

	  @Override
	  public BinarySolution createSolution() {
	    return new DefaultBinarySolution(this) ;
	  }

	  @Override
	  public void evaluate(BinarySolution solution){
	    String solutionString ="";
	    String evaluationResultString ="";
	    BitSet bitset = solution.getVariableValue(0) ;
	    solutionString = bitset.toString();
	    try {
			String line;
	    	Process p = Runtime.getRuntime().exec("java -jar " + jarPath+ " " + solutionString);
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
	    	solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
	    }	    	    
	    calculatedConfigurations++;
	  }
	  
	  public int getCalculatedConfigurations()	{
			return calculatedConfigurations;
		}
	}
