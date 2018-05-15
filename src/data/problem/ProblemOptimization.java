/**
 * 
 */
package data.problem;

import java.util.ArrayList;

import data.utils.Algorithms;

/**
 * This class will contain the list of algorithms to run using the given configuration lists by the client.
 * @author skner
 *
 */
public class ProblemOptimization {

	private boolean manualSelection;
	private ArrayList<Algorithms> algorithmList;
	
	public ProblemOptimization()	{
		manualSelection = false;
		// TODO Select algorithms automatically, depending on configuration list
	}
	
	public ProblemOptimization(ArrayList<Algorithms> algorithmList) {
		manualSelection = true;
		this.algorithmList = algorithmList;
	}

	/*
	 * GETTERS
	 */
	public boolean isManualSelection() {
		return manualSelection;
	}

	public ArrayList<Algorithms> getAlgorithmList() {
		return algorithmList;
	}

}
