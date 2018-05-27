package threads;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import data.comm.Email;
import data.comm.EmailSender;
import data.jmetal.ExperimentsBinaryExternalViaJAR;
import data.jmetal.ExperimentsDoubleExternalViaJAR;
import data.jmetal.ExperimentsIntegerExternalViaJAR;
import data.problem.Problem;
import data.problem.ProblemInputs;
import utilities.Algorithm;
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
	private ExperimentsDoubleExternalViaJAR eDouble;
	private ExperimentsIntegerExternalViaJAR eInteger;
	private ExperimentsBinaryExternalViaJAR eBinary;
	
	private double minValue;
	private double maxValue ;
	private ArrayList<Algorithm> algorithmList;
	
	public JMetalWorker(Problem problem)	{
		this.problem = problem;
		// We are assuming however, that the JMETALWORKER is working over one configList array ONLY
		// This means we must NORMALIZE the arrays
		// Until we do so, we will use and test only ONE configuration per submission/problem. Only the first config list will be considered
		setBounds();
		workerLogger = new ConsoleLogger("JMETAL-WORKER");
		Email email = new Email(this.problem);
		email.welcome_email();
		new EmailSender().sendMail(email);
		start();
	}
	
	private void setBounds() {
		double minValueAux = 0.0;
		double maxValueAux = 0.0;
		for(int i = 0; i < problem.getInputs().getConfigList().size(); i++) { 
			minValueAux = problem.getInputs().getConfigList().get(i).getLowerLimit();
			maxValueAux = problem.getInputs().getConfigList().get(i).getUpperLimit();
			if(minValue> minValueAux)
				minValue = minValueAux;
			if(maxValue< maxValueAux)
				maxValue = maxValueAux;
		}
	}
	
	@Override
	public synchronized void run()	{
		//Here is where the algorithm calls will be made.
		workerLogger.writeConsoleLog("Received problem \"" + problem.getIntroduction().getName() + "\" from " + problem.getIntroduction().getUserEmail());
		int counterDouble=0;
		int counterInteger=0;
		int counterBinary=0;
		for(int i = 0; i < problem.getInputs().getConfigList().size(); i++) {
			if( problem.getInputs().getConfigList().get(i).getVarType() == VariableType.varDouble) {
				counterDouble++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType() == VariableType.varInt) {
				counterInteger++;
			}
			if( problem.getInputs().getConfigList().get(i).getVarType() == VariableType.varBoolean) {
				counterBinary++;
			}
		}
		/*
		 * NORMALIZE ALL OF THISISISISISI 
		 */
		if( counterDouble == problem.getInputs().getConfigList().size()) {
			eDouble = new ExperimentsDoubleExternalViaJAR(
					problem.getInputs().getConfigList().get(0).getValueArray().length,
					problem.getFitnessApp().getFitnessOutputList().size(), minValue,  maxValue,  
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
			eDouble.start();
		}
		if(counterInteger == problem.getInputs().getConfigList().size()) {
			eInteger = new ExperimentsIntegerExternalViaJAR(
					problem.getInputs().getConfigList().get(0).getValueArray().length, 
					problem.getFitnessApp().getFitnessOutputList().size(),  minValue,  maxValue,  
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
			eInteger.start();
		}
		if(counterBinary == problem.getInputs().getConfigList().size()) {
			//TODO: put the parameter numberOfBits on nemesis-app
			eBinary = new ExperimentsBinaryExternalViaJAR(
					problem.getInputs().getConfigList().get(0).getValueArray().length,
					problem.getFitnessApp().getFitnessOutputList().size(),
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
			eBinary.start();
		}
	}
	
	public ExperimentsDoubleExternalViaJAR getExperimentDouble()	{
		return eDouble;
	}
	public ExperimentsIntegerExternalViaJAR getExperimentInteger()	{
		return eInteger;
	}
	public ExperimentsBinaryExternalViaJAR getExperimentBinary()	{
		return eBinary;
	}
	
	public Problem getProblem()	{
		return problem;
	}
	
}