package data.jmetal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.gde3.GDE3Builder;
import org.uma.jmetal.algorithm.multiobjective.ibea.IBEABuilder;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.mochc.MOCHCBuilder;
import org.uma.jmetal.algorithm.multiobjective.moead.MOEADBuilder;
import org.uma.jmetal.algorithm.multiobjective.moead.MOEADBuilder.Variant;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.algorithm.multiobjective.spea2.SPEA2Builder;
import org.uma.jmetal.operator.impl.crossover.HUXCrossover;
import org.uma.jmetal.operator.impl.crossover.IntegerSBXCrossover;
import org.uma.jmetal.operator.impl.crossover.SBXCrossover;
import org.uma.jmetal.operator.impl.crossover.SinglePointCrossover;
import org.uma.jmetal.operator.impl.mutation.BitFlipMutation;
import org.uma.jmetal.operator.impl.mutation.IntegerPolynomialMutation;
import org.uma.jmetal.operator.impl.mutation.PolynomialMutation;
import org.uma.jmetal.operator.impl.selection.RandomSelection;
import org.uma.jmetal.operator.impl.selection.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.BinaryProblem;
import org.uma.jmetal.problem.DoubleProblem;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.*;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import data.AdminOptions;
import utilities.Paths;
import utilities.VariableType;

/**
 * This class will contain all the information related to the JMETAL framework. Will have all the 3 used variable types for JMETAL and will also be the main
 * link between @see JMetalWorker and the JMetal's platform itself.
 * @author skner
 *
 */
public class Experiments {
	
	private Experiment<BinarySolution, List<BinarySolution>> binaryExperiment;
	private List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> binaryAlgorithms;
	private MyProblemBinaryExternalViaJAR myBinaryProblem;
	
	private Experiment<DoubleSolution, List<DoubleSolution>> doubleExperiment;
	private List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> doubleAlgorithms;
	private MyProblemDoubleExternalViaJAR myDoubleProblem;
	
	private MyProblemIntegerExternalViaJAR myIntegerProblem;
	private Experiment<IntegerSolution, List<IntegerSolution>> integerExperiment;
	private List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> integerAlgorithms;
	
	private ArrayList<String> algorithmsUsed;
	private VariableType varType;
	private boolean successful;
	private String problemName;
	private AdminOptions options;
	
	public Experiments(String varType, int numberOfVariables, int numberOfObjetives, double minValue, double maxValue,
			  String problemName, String jarPath, ArrayList<utilities.Algorithm> algorithmListNemesis, AdminOptions options)	{
		setVarType(varType);
		successful = false;
		algorithmsUsed = new ArrayList<String>();
		this.options = options;
		this.problemName = problemName;
		try {
			FileUtils.deleteDirectory(new File(Paths.EXPERIMENTS_FOLDER + problemName + "/"));
			new File(Paths.EXPERIMENTS_FOLDER + problemName + "/").delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(this.varType == VariableType.varBoolean)	{
			myBinaryProblem = new MyProblemBinaryExternalViaJAR(numberOfVariables, numberOfObjetives, problemName, jarPath);
			List<ExperimentProblem<BinarySolution>> problemList = new ArrayList<>();
			problemList.add(new ExperimentProblem<>(myBinaryProblem));
			List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithmList = configureBinaryAlgorithmList(problemList, algorithmListNemesis);
			binaryExperiment= new ExperimentBuilder<BinarySolution, List<BinarySolution>>(problemName)
				.setAlgorithmList(algorithmList)
				.setProblemList(problemList)
				.setExperimentBaseDirectory(Paths.EXPERIMENTS_FOLDER)
				.setOutputParetoFrontFileName("FUN")
				.setOutputParetoSetFileName("VAR")
				.setReferenceFrontDirectory(Paths.EXPERIMENTS_FOLDER+problemName+Paths.REFERENCE_FRONTS)
				.setIndicatorList(Arrays.asList(new PISAHypervolume<BinarySolution>()))
				.setIndependentRuns(options.getIndependentRuns())
				.setNumberOfCores(8)
				.build();
		}	else if(this.varType == VariableType.varDouble) {
			myDoubleProblem = new MyProblemDoubleExternalViaJAR(numberOfVariables, numberOfObjetives , minValue, maxValue , problemName , jarPath);
			List<ExperimentProblem<DoubleSolution>> problemList = new ArrayList<>();
			problemList.add(new ExperimentProblem<>(myDoubleProblem));
			List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> algorithmList = configureDoubleAlgorithmList(problemList, algorithmListNemesis);
			doubleExperiment = new ExperimentBuilder<DoubleSolution, List<DoubleSolution>>(problemName)
	            .setAlgorithmList(algorithmList)
	            .setProblemList(problemList)
	            .setExperimentBaseDirectory(Paths.EXPERIMENTS_FOLDER)
	            .setOutputParetoFrontFileName("FUN")
	            .setOutputParetoSetFileName("VAR")
	            .setReferenceFrontDirectory(Paths.EXPERIMENTS_FOLDER+problemName+Paths.REFERENCE_FRONTS)
	            .setIndicatorList(Arrays.asList(new PISAHypervolume<DoubleSolution>()))
	            .setIndependentRuns(options.getIndependentRuns())
	            .setNumberOfCores(8)
	            .build();
		}	else if(this.varType == VariableType.varInt) {
			myIntegerProblem = new MyProblemIntegerExternalViaJAR(numberOfVariables, numberOfObjetives , minValue, maxValue , problemName , jarPath);
			List<ExperimentProblem<IntegerSolution>> problemList = new ArrayList<>();
			problemList.add(new ExperimentProblem<>(myIntegerProblem));
		    List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> algorithmList = configureIntegerAlgorithmList(problemList, algorithmListNemesis);
		    integerExperiment = new ExperimentBuilder<IntegerSolution, List<IntegerSolution>>(problemName)
		            .setAlgorithmList(algorithmList)
		            .setProblemList(problemList)
		            .setExperimentBaseDirectory(Paths.EXPERIMENTS_FOLDER)
		            .setOutputParetoFrontFileName("FUN")
		            .setOutputParetoSetFileName("VAR")
		            .setReferenceFrontDirectory(Paths.EXPERIMENTS_FOLDER+problemName+Paths.REFERENCE_FRONTS)
		            .setIndicatorList(Arrays.asList(new PISAHypervolume<IntegerSolution>()))
		            .setIndependentRuns(options.getIndependentRuns())
		            .setNumberOfCores(8)
		            .build();
		}
	}
	
	public void start()	{
		if(varType == VariableType.varBoolean)	{
			new ExecuteAlgorithms<>(binaryExperiment).run();
			try {
				new GenerateReferenceParetoSetAndFrontFromDoubleSolutions(binaryExperiment).run();
				new ComputeQualityIndicators<>(binaryExperiment).run();
				new GenerateLatexTablesWithStatistics(binaryExperiment).run();
				new GenerateBoxplotsWithR<>(binaryExperiment).setRows(1).setColumns(1).run();
				successful = true;
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}	else if(this.varType == VariableType.varDouble) {
			new ExecuteAlgorithms<>(doubleExperiment).run();
		    try {
				new GenerateReferenceParetoSetAndFrontFromDoubleSolutions(doubleExperiment).run();
				new ComputeQualityIndicators<>(doubleExperiment).run();
				new GenerateLatexTablesWithStatistics(doubleExperiment).run();
				new GenerateBoxplotsWithR<>(doubleExperiment).setRows(1).setColumns(1).run();
				successful = true;
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}	else if(this.varType == VariableType.varInt) {
			new ExecuteAlgorithms<>(integerExperiment).run();
		    try {
				new GenerateReferenceParetoSetAndFrontFromDoubleSolutions(integerExperiment).run();
				new ComputeQualityIndicators<>(integerExperiment).run();
				new GenerateLatexTablesWithStatistics(integerExperiment).run();
				new GenerateBoxplotsWithR<>(integerExperiment).setRows(1).setColumns(1).run();
				successful = true;
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Configures the experiment to hold a binary solution, calling JMetal's binary algorithms.
	 * @param problemList The list with the problem's information.
	 * @param algorithmListNemesis List of algorithms to be used, either chosen by the user, or chosen automatically by the system.
	 * @return Returns lists to be delivered to the JMetal's framework.
	 */
	private List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> configureBinaryAlgorithmList(
			List<ExperimentProblem<BinarySolution>> problemList, ArrayList<utilities.Algorithm> algorithmListNemesis) {
		//String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};
		binaryAlgorithms = new ArrayList<>();
		for (int i = 0; i < problemList.size(); i++) {			  
			for(int j = 0; j < algorithmListNemesis.size(); j++) {		    		
				if (algorithmListNemesis.get(j).name().equals("nsgaii")) {  			
					Algorithm<List<BinarySolution>> algorithm = new NSGAIIBuilder<>(
							problemList.get(i).getProblem(),
							new SinglePointCrossover(1.0),
							new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0)))
							.setMaxEvaluations(options.getMaxEvaluations())
							.setPopulationSize(options.getPopulationSize())
							.build();
					binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm, "NSGAII", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("smsemoa")) {
	    			Algorithm<List<BinarySolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(options.getMaxEvaluations()).build();      
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("mocell")) {
	    			Algorithm<List<BinarySolution>> algorithm3 = new MOCellBuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(options.getMaxEvaluations()).build();
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("mochc")) {
	    			Algorithm<List<BinarySolution>> algorithm4 = new MOCHCBuilder((BinaryProblem) problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations())
	    					.setCrossover(new HUXCrossover(1.0)).setNewGenerationSelection(new RankingAndCrowdingSelection<BinarySolution>(100)).setCataclysmicMutation(new BitFlipMutation(0.35)).setParentSelection(new RandomSelection<BinarySolution>()).setEvaluator(new SequentialSolutionListEvaluator<BinarySolution>()).build();
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm4, "MOCHC", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("paes")) {
	    			Algorithm<List<BinarySolution>> algorithm5 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).setArchiveSize(100).setBiSections(2).setMutationOperator(new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).build();
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm5, "PAES", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("randomsearch")) {
	    			Algorithm<List<BinarySolution>> algorithm6 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).build();
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm6, "RandomSearch", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("spea2")) {
	    			System.out.println("Corri algoritmo SPEA2");
	    			Algorithm<List<BinarySolution>> algorithm7 = new SPEA2Builder<>(problemList.get(i).getProblem(),new SinglePointCrossover(1.0),new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxIterations(options.getMaxEvaluations()).build();
	    			binaryAlgorithms.add(new ExperimentAlgorithm<>(algorithm7, "SPEA2", problemList.get(i).getTag()));
	    		}
			}
		}
		for(int i = 0; i<binaryAlgorithms.size(); i++)	{
			algorithmsUsed.add(binaryAlgorithms.get(i).getAlgorithmTag());
		}
		return binaryAlgorithms;
	}
	
	/**
	 * Configures the experiment to hold a double solution, calling JMetal's double algorithms.
	 * @param problemList The list with the problem's information.
	 * @param algorithmListNemesis List of algorithms to be used, either chosen by the user, or chosen automatically by the system.
	 * @return Returns lists to be delivered to the JMetal's framework.
	 */
	private List<ExperimentAlgorithm<DoubleSolution, List<DoubleSolution>>> configureDoubleAlgorithmList(
			List<ExperimentProblem<DoubleSolution>> problemList, ArrayList<utilities.Algorithm> algorithmListNemesis) {
		//String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
		doubleAlgorithms = new ArrayList<>();
		for (int i = 0; i < problemList.size(); i++) {
			for(int j=0; j< algorithmListNemesis.size();j++) {
				if ( algorithmListNemesis.get(j).name().equals("nsgaii")) {
					Algorithm<List<DoubleSolution>> algorithm1 = new NSGAIIBuilder<>(
							problemList.get(i).getProblem(),
							new SBXCrossover(1.0, 5),
							new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0))
							.setMaxEvaluations(options.getMaxEvaluations())
							.setPopulationSize(options.getPopulationSize())
							.build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm1, "NSGAII", problemList.get(i).getTag()));
				}
				else if (algorithmListNemesis.get(j).name().equals("smsemoa")) {
					Algorithm<List<DoubleSolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new SBXCrossover(1.0, 5), new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0)).setMaxEvaluations(options.getMaxEvaluations()).build();      
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("gde3")) {
					Algorithm<List<DoubleSolution>> algorithm3 = new GDE3Builder((DoubleProblem) problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm3, "GDE3", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("ibea")) {
					Algorithm<List<DoubleSolution>> algorithm4 = new IBEABuilder(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm4, "IBEA", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("mocell")) {
					Algorithm<List<DoubleSolution>> algorithm5 = new MOCellBuilder<>(problemList.get(i).getProblem(),new SBXCrossover(1.0, 5), new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0)).setMaxEvaluations(options.getMaxEvaluations()).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm5, "MOCell", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("moead")) {
					Algorithm<List<DoubleSolution>> algorithm6 = new MOEADBuilder(problemList.get(i).getProblem(),Variant.MOEAD).setMaxEvaluations(options.getMaxEvaluations()).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm6, "MOEAD", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("paes")) {
					Algorithm<List<DoubleSolution>> algorithm7 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).setArchiveSize(100).setBiSections(2).setMutationOperator(new PolynomialMutation(1.0 / problemList.get(i).getProblem().getNumberOfVariables(), 10.0)).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm7, "PAES", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("randomsearch")) {
					Algorithm<List<DoubleSolution>> algorithm8 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).build();
					doubleAlgorithms.add(new ExperimentAlgorithm<>(algorithm8, "RandomSearch", problemList.get(i).getTag()));
				}
			}
		}
		for(int i = 0; i<doubleAlgorithms.size(); i++)	{
			algorithmsUsed.add(doubleAlgorithms.get(i).getAlgorithmTag());
		}
		return doubleAlgorithms;
	}
	
	/**
	 * Configures the experiment to hold a integer solution, calling JMetal's integer algorithms.
	 * @param problemList The list with the problem's information.
	 * @param algorithmListNemesis List of algorithms to be used, either chosen by the user, or chosen automatically by the system.
	 * @return Returns lists to be delivered to the JMetal's framework.
	 */
	private List<ExperimentAlgorithm<IntegerSolution, List<IntegerSolution>>> configureIntegerAlgorithmList(
			List<ExperimentProblem<IntegerSolution>> problemList, ArrayList<utilities.Algorithm> algorithmListNemesis) {
		//String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	    integerAlgorithms = new ArrayList<>();

	    for (int i = 0; i < problemList.size(); i++) {
	    	for(int j=0; j< algorithmListNemesis.size();j++) {
	    		if ( algorithmListNemesis.get(j).name().equals("nsgaii")) {
	    			Algorithm<List<IntegerSolution>> algorithm1 = new NSGAIIBuilder<>(
	    					problemList.get(i).getProblem(),
	    					new IntegerSBXCrossover(0.9, 20.0),
	    					new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0))
							.setMaxEvaluations(options.getMaxEvaluations())
							.setPopulationSize(options.getPopulationSize())
	    					.build();
	    			integerAlgorithms.add(new ExperimentAlgorithm<>(algorithm1, "NSGAII", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("smsemoa")) {
	    			Algorithm<List<IntegerSolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new IntegerSBXCrossover(0.9, 20.0),new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).setMaxEvaluations(options.getMaxEvaluations()).build();      
	    			integerAlgorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("mocell")) {
	    			Algorithm<List<IntegerSolution>> algorithm3 = new MOCellBuilder<>(problemList.get(i).getProblem(),new IntegerSBXCrossover(0.9, 20.0), new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).setMaxEvaluations(options.getMaxEvaluations()).build();
	    			integerAlgorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag()));
				}	else if ( algorithmListNemesis.get(j).name().equals("paes")) {
	    			Algorithm<List<IntegerSolution>> algorithm4 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).setArchiveSize(100).setBiSections(2).setMutationOperator(new IntegerPolynomialMutation(1/problemList.get(i).getProblem().getNumberOfVariables(), 20.0)).build();
	    			integerAlgorithms.add(new ExperimentAlgorithm<>(algorithm4, "PAES", problemList.get(i).getTag()));
	    		}	else if ( algorithmListNemesis.get(j).name().equals("randomsearch")) {
	    			Algorithm<List<IntegerSolution>> algorithm5 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(options.getMaxEvaluations()).build();
	    			integerAlgorithms.add(new ExperimentAlgorithm<>(algorithm5, "RandomSearch", problemList.get(i).getTag()));
	    		}
	    	}
	    }
		for(int i = 0; i<integerAlgorithms.size(); i++)	{
			algorithmsUsed.add(integerAlgorithms.get(i).getAlgorithmTag());
		}
	    return integerAlgorithms;
	  }
	
	private void setVarType(String type)	{
		if(type.equals("int")) {
			varType = VariableType.varInt;
		}
		else if(type.equals("double")) {	
			varType = VariableType.varDouble;
		}
		else if(type.equals("boolean")) {
			varType = VariableType.varBoolean;
		}	else {
			varType = VariableType.varUndefined;
		}
	}
	
	public int getTotalConfigurations()	{
		if(varType == VariableType.varBoolean)
			return (int) (Math.ceil(options.getMaxEvaluations()/options.getPopulationSize())*options.getIndependentRuns()*options.getPopulationSize()*binaryAlgorithms.size());
		if(varType == VariableType.varDouble)
			return (int) (Math.ceil(options.getMaxEvaluations()/options.getPopulationSize())*options.getIndependentRuns()*options.getPopulationSize()*doubleAlgorithms.size());
		if(varType == VariableType.varInt)
			return (int) (Math.ceil(options.getMaxEvaluations()/options.getPopulationSize())*options.getIndependentRuns()*options.getPopulationSize()*integerAlgorithms.size());
		return -1;
	}
	
	public int getCompletedRuns()	{
		int res = 0;
		for(int i = 0; i<options.getIndependentRuns(); i++)	{
			File f = new File(Paths.EXPERIMENTS_FOLDER+problemName+"/data/"+algorithmsUsed.get(0)+"/"+problemName+"/FUN" + i + ".tsv");
			if(f.exists() && !f.isDirectory()) { 
				res++;
			}
		}
		return res;
	}
	
	public int getTotalRuns()	{
		return options.getIndependentRuns();
	}
	
	public MyProblemBinaryExternalViaJAR getMyBinaryProblem()	{
		return myBinaryProblem;
	}
	public MyProblemDoubleExternalViaJAR getMyDoubleProblem()	{
		return myDoubleProblem;
	}
	public MyProblemIntegerExternalViaJAR getMyIntegerProblem()	{
		return myIntegerProblem;
	}

	public VariableType getProblemVarType()	{
		return varType;
	}

	public boolean wasSuccessfull() {
		return successful;
	}
}















