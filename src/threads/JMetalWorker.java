package threads;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.jmetal.ExperimentsBinaryExternalViaJAR;
import data.jmetal.ExperimentsDoubleExternalViaJAR;
import data.jmetal.ExperimentsIntegeExternalViaJAR;
import data.problem.Problem;
import data.problem.ProblemInputs;
import utilities.ConsoleLogger;
import utilities.VariableType;

/**
 * This thread will run algorithm calculation, so that multiple algorithms can be running at the same time.
 * This class will also be responsible for calculating the process's completion percentage, and call the EmailSender to send the respective emails to the user.
 * 
 * @author skner
 *
 */
public class JMetalWorker extends Thread {

	private Problem problem;
	private ConsoleLogger workerLogger;
	
	private int configListSize;
	
	private int numberOfObjetives ;
	private int numberOfVariables ;
	private double minValue;
	private double maxValue ;
	private String problemName;
	private String jarPath;
	
	public JMetalWorker(Problem problem)	{
		// Possible TODO: Remove redundant fields
		this.problem = problem;
		configListSize= problem.getInputs().getConfigList().size();
		numberOfObjetives = problem.getFitnessApp().getFitnessOutputList().size();
		
		// We are assuming however, that the JMETALWORKER is working over one configList array ONLY
		// This means we must NORMALIZE the arrays
		// Until we do so, we will use and test only ONE configuration per submission/problem
		numberOfVariables = problem.getInputs().getConfigList().get(0).getValueArray().length;
		setBounds();
		problemName= problem.getIntroduction().getName();
		jarPath= problem.getFitnessApp().getLocalJarPath();
		
		workerLogger = new ConsoleLogger("JMETALWORKER");
		start();
	}
	
	private void setBounds() {
		
		double minValueAux = 0.0;
		double maxValueAux = 0.0;
		for( int i=0;i < configListSize; i++) {
			minValueAux = problem.getInputs().getConfigList().get(i).getLowerLimit();
			maxValueAux = problem.getInputs().getConfigList().get(i).getUpperLimit();
			
			if(minValue> minValueAux) {
				minValue = minValueAux;
			}
			if(maxValue< maxValueAux) {
				maxValue = maxValueAux;
			}
		}
		
		
	}
	
	@Override
	public void run()	{
		//Here is where the algorithm calls will be made.
		workerLogger.writeConsoleLog("Received problem \"" + problem.getIntroduction().getName() + "\" from " + problem.getIntroduction().getUserEmail());
		
		int counterDouble=0;
		int counterInteger=0;
		int counterBinary=0;
		for( int i=0;i < configListSize; i++) {
			if( problem.getInputs().getConfigList().get(i).getVarType()== VariableType.varDouble) {
				counterDouble++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType()== VariableType.varInt) {
				counterInteger++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType() ==VariableType.varBoolean) {
				counterBinary++;
			}
		}
		
		if( counterDouble== configListSize) {
			System.out.println("Sending " + numberOfVariables + " variables to MyProblem class");
			System.out.println("Caminho para o .jar = \""+ jarPath + "\"");
			new ExperimentsDoubleExternalViaJAR(numberOfVariables,  numberOfObjetives,  minValue,  maxValue,  problemName, jarPath);
			
			
			/*
			try {
				ExperimentsDoubleExternalViaJAR.main(null);
			} catch (IOException e) {
				
				e.printStackTrace();
			}*/
		}
		if( counterInteger== configListSize) {
			try {
				ExperimentsIntegeExternalViaJAR.main(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if( counterBinary== configListSize) {
			try {
				ExperimentsBinaryExternalViaJAR.main(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}
	
}