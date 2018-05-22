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
	 * atributos abaixo apenas para teste
	 */
	
	private int numberOfObjetives = problem.getFitnessApp().getFitnessOutputList().size();
	private int numberOfVariables = problem.getInputs().getConfigList().size() ;
	private double minValue = problem.getInputs().getConfigList().get(0).getLowerLimit();
	private double maxValue = problem.getInputs().getConfigList().get(0).getUpperLimit();
	
	/*
	private String problemName = problem.getIntroduction().getName();
	private String jarPath = problem.getFitnessApp().getLocalJarPath();
	*/
	private String problemName = "Kursawe";
	private String jarPath = "./caseStudies/Kursawe.jar";
	
	public JMetalWorker(Problem problem)	{
		this.problem = problem;
		/*
		 * verificar qual é a vantagem de colocar estas variaveis no construtor 
		 * 
		configListSize = problem.getInputs().getConfigList().size();
		minValue = problem.getInputs().getConfigList().get(0).getLowerLimit();
		maxValue = problem.getInputs().getConfigList().get(0).getUpperLimit();
		*/
		workerLogger = new ConsoleLogger("JMETALWORKER");
		start();
	}
	
	@Override
	public void run()	{
		
		int counterDouble=0;
		int counterInteger=0;
		int counterBinary=0;
		for( int i=0;i < configListSize-1; i++) {
			//problem.getInputs().getConfigList().get(i).setArrayType("double");//apenas para efeitos de teste
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
		
		
		//Here is where the algorithm calls will be made.
		workerLogger.writeConsoleLog("Received problem \"" + problem.getIntroduction().getName() + "\" from " + problem.getIntroduction().getUserEmail());

	}
	
}