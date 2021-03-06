package threads;

import java.util.ArrayList;

import data.AdminOptions;
import data.comm.Email;
import data.comm.EmailSender;
import data.jmetal.Experiments;
import data.problem.Problem;
import data.results.ResultsOptimizer;
import utilities.Algorithm;
import utilities.ConsoleLogger;
import utilities.JSONResultsGenerator;
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
	private ConsoleLogger logger;
	private Experiments experiments;
	
	private double finishedRunTime;
	private double minValue;
	private double maxValue ;
	private ArrayList<Algorithm> algorithmList;
	private AdminOptions options;
	
	public JMetalWorker(Problem problem, AdminOptions options)	{
		this.problem = problem;
		this.options = options;
		// We are assuming however, that the JMETALWORKER is working over one configList array ONLY
		// This means we must NORMALIZE the arrays
		// Until we do so, we will use and test only ONE configuration per submission/problem. Only the first config list will be considered
		setBounds();
		logger = new ConsoleLogger("JMETAL-WORKER");
		Email email = new Email(this.problem, options);
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
		logger.writeConsoleLog("Received problem \"" + problem.getIntroduction().getName() + "\" from " + problem.getIntroduction().getUserEmail());
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
					problem.getOptimization().getAlgorithmList(),
					options);
		}
		if(counterInteger == problem.getInputs().getConfigList().size()) {
			experiments = new Experiments(
					"int",
					problem.getInputs().getConfigList().get(0).getValueArray().length, 
					problem.getFitnessApp().getFitnessOutputList().size(),  minValue,  maxValue,  
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList(),
					options);
		}
		if(counterBinary == problem.getInputs().getConfigList().size()) {
			experiments = new Experiments(
					"boolean",
					problem.getInputs().getConfigList().get(0).getValueArray().length,
					problem.getFitnessApp().getFitnessOutputList().size(), 0, 0, 
					problem.getIntroduction().getName(), 
					problem.getFitnessApp().getLocalJarPath(), 
					problem.getOptimization().getAlgorithmList(),
					options);
		}
		try	{
			experiments.start();
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.writeConsoleLog("Process was interruped. There were inconcistencies on the JSON submission or the given JAR evaluator.");
			Email email = new Email(this.problem, options);
			email.fail_email();
			new EmailSender().sendMail(email);
			return;
		}
		
		if(experiments.wasSuccessfull())	{
			logger.writeConsoleLog("Process was successful. Generating results files.");
		}
		compileResultsJSON();
		Email email = new Email(this.problem, options);
		email.success_email();
		new EmailSender().sendMail(email);
	}
	
	public void compileResultsJSON()	{
		ResultsOptimizer.optimize(problem.getIntroduction().getName(), 5);
		JSONResultsGenerator.convertResultsAndSolutionsToJSON(
				problem.getIntroduction().getName(), 
				problem.getIntroduction().getFullDescription(),
				problem.getIntroduction().getUserEmail(),
				problem.getFitnessApp().getFitnessAppName(),
				(int)(finishedRunTime/1000),
				problem.getFitnessApp().getFitnessOutputsAsArray(),
				problem.getInputs().getConfigList().get(0).getVariablesNames(),
				problem.getInputs().getConfigList().get(0).getVariablesNames().length);
	}
	
	public Experiments getExperiment()	{
		return experiments;
	}

	
	public Problem getProblem()	{
		return problem;
	}
	
	public void setRunTime(double runTime)	{
		finishedRunTime = runTime;
	}
	
	public AdminOptions getAdminOptions()	{
		return options;
	}
}