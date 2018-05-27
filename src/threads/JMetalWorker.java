package threads;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import data.comm.Email;
import data.comm.EmailSender;
import data.jmetal.Experiments;
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
	private Experiments experiments;
	
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
	
	//This method normalizes the minimum and maximum limits  
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
		//On this thread we check the type of problem and run the respective algorithms
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

		if(counterDouble == problem.getInputs().getConfigList().size()) {
			experiments = new Experiments(
					"double", 
					problem.getInputs().getConfigList().get(0).getValueArray().length,
					problem.getFitnessApp().getFitnessOutputList().size(), minValue,  maxValue,  
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
		}
		if(counterInteger == problem.getInputs().getConfigList().size()) {
			experiments = new Experiments(
					"int",
					problem.getInputs().getConfigList().get(0).getValueArray().length, 
					problem.getFitnessApp().getFitnessOutputList().size(),  minValue,  maxValue,  
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
		}
		if(counterBinary == problem.getInputs().getConfigList().size()) {
			//TODO: put the parameter numberOfBits on nemesis-app
			experiments = new Experiments(
					"boolean",
					problem.getInputs().getConfigList().get(0).getValueArray().length,
					problem.getFitnessApp().getFitnessOutputList().size(), 0, 0, 
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList());
		}
		experiments.start();
	}
	
	public Experiments getExperiment()	{
		return experiments;
	}

	
	public Problem getProblem()	{
		return problem;
	}
	
}