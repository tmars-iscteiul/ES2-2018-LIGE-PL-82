package data.jmetal;

import java.io.IOException;

import data.problem.ProblemInputs;

public class OptimizationProcess {
	
	/*all the algorithms for each problem type*/
	String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	

	
	public void runProblemType() {
		
		
	}
	
	public static void main(String[] args) {
		/*try {
			
			
			ExperimentsDoubleExternalViaJAR.main(null);
			ExperimentsIntegeExternalViaJAR.main(null);
			ExperimentsBinaryExternalViaJAR.main(null);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	} */
	}
	
}
