package threads;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import data.jmetal.problems.ExperimentsBinaryExternalViaJAR;
import data.jmetal.problems.ExperimentsDoubleExternalViaJAR;
import data.jmetal.problems.ExperimentsIntegeExternalViaJAR;
import data.problem.Problem;
import data.problem.ProblemInputs;
import utilities.ConsoleLogger;

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
	
	/*
	 * atributo abaixo apenas para teste
	 */
	
	private String problemName ;
	private double minValue = problem.getInputs().getConfigList().get(0).getLowerLimit();
	private double maxValue = problem.getInputs().getConfigList().get(0).getUpperLimit();
	private int size ;

	public JMetalWorker(Problem problem)	{
		this.problem = problem;
		configListSize = problem.getInputs().getConfigList().size();
		workerLogger = new ConsoleLogger("JMETALWORKER");
		start();
	}
	
	@Override
	public void run()	{
		
		int counterDouble=0;
		int counterInteger=0;
		int counterBinary=0;
		for( int i=0;i < configListSize; i++) {
			problem.getInputs().getConfigList().get(i).setArrayType("double");//apenas para efeitos de teste
			if( problem.getInputs().getConfigList().get(i).getVarType().equals("double")) {
				counterDouble++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType().equals("int")) {
				counterInteger++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType().equals("boolean")) {
				counterBinary++;
			}
		}
		
		if( counterDouble== configListSize) {
			System.out.println("Entrei no if Double");
			
			//new ExperimentsDoubleExternalViaJAR();
			
			
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
		
		
		//Here is where the algorithm calls will be made.
		workerLogger.writeConsoleLog("Received problem \"" + problem.getIntroduction().getName() + "\" from " + problem.getIntroduction().getUserEmail());

	}
	
}
