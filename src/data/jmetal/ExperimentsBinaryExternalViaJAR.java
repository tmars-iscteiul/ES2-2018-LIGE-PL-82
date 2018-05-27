package data.jmetal;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.mocell.MOCellBuilder;
import org.uma.jmetal.algorithm.multiobjective.mochc.MOCHCBuilder;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.algorithm.multiobjective.paes.PAESBuilder;
import org.uma.jmetal.algorithm.multiobjective.randomsearch.RandomSearchBuilder;
import org.uma.jmetal.algorithm.multiobjective.smsemoa.SMSEMOABuilder;
import org.uma.jmetal.algorithm.multiobjective.spea2.SPEA2Builder;
import org.uma.jmetal.operator.impl.crossover.HUXCrossover;
import org.uma.jmetal.operator.impl.crossover.SinglePointCrossover;
import org.uma.jmetal.operator.impl.mutation.BitFlipMutation;
import org.uma.jmetal.operator.impl.selection.RandomSelection;
import org.uma.jmetal.operator.impl.selection.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.BinaryProblem;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;
import org.uma.jmetal.util.experiment.Experiment;
import org.uma.jmetal.util.experiment.ExperimentBuilder;
import org.uma.jmetal.util.experiment.component.*;
import org.uma.jmetal.util.experiment.util.ExperimentAlgorithm;
import org.uma.jmetal.util.experiment.util.ExperimentProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utilities.Paths;

public class ExperimentsBinaryExternalViaJAR {
	
  private Experiment<BinarySolution, List<BinarySolution>> experiment;
  private static final int INDEPENDENT_RUNS = 2;
  private static final int maxEvaluations = 250;
  private static final int populationSize = 100;
  private MyProblemBinaryExternalViaJAR myProblem;
  
  //The constructor choose the folder where the results of the optimization will be
  public ExperimentsBinaryExternalViaJAR(int numberOfVariables, int numberOfObjetives,
		  String problemName, String jarPath, ArrayList<utilities.Algorithm> algorithmListNemesis) {

	  myProblem = new MyProblemBinaryExternalViaJAR(numberOfVariables, numberOfObjetives , problemName , jarPath);
	  List<ExperimentProblem<BinarySolution>> problemList = new ArrayList<>();
	  problemList.add(new ExperimentProblem<>(myProblem));


	  List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithmList = configureAlgorithmList(problemList, algorithmListNemesis);
	  

	  experiment= new ExperimentBuilder<BinarySolution, List<BinarySolution>>(problemName)
			  .setAlgorithmList(algorithmList)
			  .setProblemList(problemList)
			  .setExperimentBaseDirectory(Paths.EXPERIMENTS_FOLDER)
			  .setOutputParetoFrontFileName("FUN")
			  .setOutputParetoSetFileName("VAR")
			  .setReferenceFrontDirectory(Paths.EXPERIMENTS_FOLDER+problemName+Paths.REFERENCE_FRONTS)
			  .setIndicatorList(Arrays.asList(new PISAHypervolume<BinarySolution>()))
			  .setIndependentRuns(INDEPENDENT_RUNS)
			  .setNumberOfCores(8)
			  .build();

  }
  
  public void start()	{
	    new ExecuteAlgorithms<>(experiment).run();
	    try {
			new GenerateReferenceParetoSetAndFrontFromDoubleSolutions(experiment).run();
			new ComputeQualityIndicators<>(experiment).run() ;
			new GenerateLatexTablesWithStatistics(experiment).run() ;
			new GenerateBoxplotsWithR<>(experiment).setRows(1).setColumns(1).run() ;
	    
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}
//This method run all the algorithms selected on nemesis-app (if the algorithm is not the correct for the problem we don´t consider them)
  static List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> configureAlgorithmList(
		  List<ExperimentProblem<BinarySolution>> problemList, ArrayList<utilities.Algorithm> algorithmListNemesis) {
	  
	  //String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};
	  List<ExperimentAlgorithm<BinarySolution, List<BinarySolution>>> algorithms = new ArrayList<>();
	  
	  for (int i = 0; i < problemList.size(); i++) {
		  
		 
		  for(int j=0; j< algorithmListNemesis.size();j++) {
	    		if ( algorithmListNemesis.get(j).name().equals("nsgaii")) {
	    			
	    			Algorithm<List<BinarySolution>> algorithm = new NSGAIIBuilder<>(
	    					problemList.get(i).getProblem(),
	    					new SinglePointCrossover(1.0),
	    					new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0)))
	    					.setMaxEvaluations(maxEvaluations)
	    					.setPopulationSize(populationSize)
	    					.build();
	    			algorithms.add(new ExperimentAlgorithm<>(algorithm, "NSGAII", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("smsemoa")) {
	    			 Algorithm<List<BinarySolution>> algorithm2 = new SMSEMOABuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(maxEvaluations).build();      
	 		        algorithms.add(new ExperimentAlgorithm<>(algorithm2, "SMSEMOA", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("mocell")) {
	    			Algorithm<List<BinarySolution>> algorithm3 = new MOCellBuilder<>(problemList.get(i).getProblem(), new SinglePointCrossover(1.0), new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxEvaluations(maxEvaluations).build();
			        algorithms.add(new ExperimentAlgorithm<>(algorithm3, "MOCell", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("mochc")) {
	    			 Algorithm<List<BinarySolution>> algorithm4 = new MOCHCBuilder((BinaryProblem) problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations)
	    					  .setCrossover(new HUXCrossover(1.0)).setNewGenerationSelection(new RankingAndCrowdingSelection<BinarySolution>(100)).setCataclysmicMutation(new BitFlipMutation(0.35)).setParentSelection(new RandomSelection<BinarySolution>()).setEvaluator(new SequentialSolutionListEvaluator<BinarySolution>()).build();
	    					        algorithms.add(new ExperimentAlgorithm<>(algorithm4, "MOCHC", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("paes")) {
	    			Algorithm<List<BinarySolution>> algorithm5 = new PAESBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).setArchiveSize(100).setBiSections(2).setMutationOperator(new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).build();
			        algorithms.add(new ExperimentAlgorithm<>(algorithm5, "PAES", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("randomsearch")) {
	    			Algorithm<List<BinarySolution>> algorithm6 = new RandomSearchBuilder<>(problemList.get(i).getProblem()).setMaxEvaluations(maxEvaluations).build();
	  		  	  algorithms.add(new ExperimentAlgorithm<>(algorithm6, "RandomSearch", problemList.get(i).getTag()));
	    		}
	    		else if ( algorithmListNemesis.get(j).name().equals("spea2")) {
	    			System.out.println("Corri algoritmo SPEA2");
	    			Algorithm<List<BinarySolution>> algorithm7 = new SPEA2Builder<>(problemList.get(i).getProblem(),new SinglePointCrossover(1.0),new BitFlipMutation(1.0 / ((MyProblemBinaryExternalViaJAR) problemList.get(i).getProblem()).getNumberOfBits(0))).setMaxIterations(maxEvaluations).build();
	  		  	  algorithms.add(new ExperimentAlgorithm<>(algorithm7, "SPEA2", problemList.get(i).getTag()));
	    		}
	    		else {
	    			System.out.println("user choose an algorithm than doesn´t fit on the problem");
	    		}
		  }
	  }
	  return algorithms;
  }

  public int getTotalConfigurations()	{
	  return (int) (Math.ceil(250.0/100)*INDEPENDENT_RUNS*populationSize);
  }

  public MyProblemBinaryExternalViaJAR getMyProblem()	{
	  return myProblem;
  }
}
