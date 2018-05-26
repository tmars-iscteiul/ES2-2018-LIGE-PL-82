package data.problem;

import java.util.ArrayList;

import utilities.Algorithm;

/**
 * This class will contain the list of algorithms to run using the given configuration lists by the client.
 * @author skner
 *
 */
public class ProblemOptimization {

	private ArrayList<Algorithm> algorithmList;
	
	public ProblemOptimization()	{
		algorithmList = new ArrayList<Algorithm>();
		// TODO Select algorithms automatically, depending on configuration list
	}
	
	public ProblemOptimization(ArrayList<Algorithm> algorithmList) {
		this.algorithmList = algorithmList;
	}
	
	public ProblemOptimization(data.submission.Optimization optimization)	{
		// TODO Is there a better way to do this?
		this();
		if(optimization.isCoralReefOptimization())
			algorithmList.add(Algorithm.coralReefOptimization);
		if(optimization.isDiferencialEvolution())
			algorithmList.add(Algorithm.diferencialEvolution);
		if(optimization.isCmaes())
			algorithmList.add(Algorithm.cmaes);
		if(optimization.isEes())
			algorithmList.add(Algorithm.ees);
		if(optimization.isNees())
			algorithmList.add(Algorithm.nees);
		if(optimization.isGga())
			algorithmList.add(Algorithm.gga);
		if(optimization.isSsga())
			algorithmList.add(Algorithm.ssga);
		if(optimization.isPwo2007())
			algorithmList.add(Algorithm.pwo2007);
		if(optimization.isPwo2011())
			algorithmList.add(Algorithm.pwo2011);
		if(optimization.isAbyss())
			algorithmList.add(Algorithm.abyss);
		if(optimization.isCellde())
			algorithmList.add(Algorithm.cellde);
		if(optimization.isDmopso())
			algorithmList.add(Algorithm.dmopso);
		if(optimization.isDmopsom())
			algorithmList.add(Algorithm.dmopsom);
		if(optimization.isGde3())
			algorithmList.add(Algorithm.gde3);
		if(optimization.isGwasfga())
			algorithmList.add(Algorithm.gwasfga);
		if(optimization.isIbea())
			algorithmList.add(Algorithm.ibea);
		if(optimization.isMocell())
			algorithmList.add(Algorithm.mocell);
		if(optimization.isMochc())
			algorithmList.add(Algorithm.mochc);
		if(optimization.isMoead())
			algorithmList.add(Algorithm.moead);
		if(optimization.isCmoead())
			algorithmList.add(Algorithm.cmoead);
		if(optimization.isMoeaddd())
			algorithmList.add(Algorithm.moeaddd);
		if(optimization.isMoeaddra())
			algorithmList.add(Algorithm.moeaddra);
		if(optimization.isMoeadstm())
			algorithmList.add(Algorithm.moeadstm);
		if(optimization.isMombi())
			algorithmList.add(Algorithm.mombi);
		if(optimization.isMombi2())
			algorithmList.add(Algorithm.mombi2);
		if(optimization.isNsgaii())
			algorithmList.add(Algorithm.nsgaii);
		if(optimization.isNsgaiim())
			algorithmList.add(Algorithm.nsgaiim);
		if(optimization.isSsnsgaii())
			algorithmList.add(Algorithm.ssnsgaii);
		if(optimization.isNsgaiii())
			algorithmList.add(Algorithm.nsgaiii);
		if(optimization.isOmopso())
			algorithmList.add(Algorithm.omopso);
		if(optimization.isPaes())
			algorithmList.add(Algorithm.paes);
		if(optimization.isPesa2())
			algorithmList.add(Algorithm.pesa2);
		if(optimization.isRandomsearch())
			algorithmList.add(Algorithm.randomsearch);
		if(optimization.isSmpso())
			algorithmList.add(Algorithm.smpso);
		if(optimization.isSmpsom())
			algorithmList.add(Algorithm.smpsom);
		if(optimization.isSmsemoa())
			algorithmList.add(Algorithm.smsemoa);
		if(optimization.isSpea2())
			algorithmList.add(Algorithm.spea2);
		if(optimization.isWasfga())
			algorithmList.add(Algorithm.wasfga);
	}

	/*
	 * GETTERS
	 */
	public ArrayList<Algorithm> getAlgorithmList() {
		return algorithmList;
	}
	
	

}
