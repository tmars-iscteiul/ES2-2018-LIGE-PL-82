package data.jmetal;

import utilities.VariableType;

/**
 * @author skner
 *
 */
public abstract class Experiments {
	
	protected static final int INDEPENDENT_RUNS = 2;
	protected static final int maxEvaluations = 250;
	protected static final int populationSize = 100;
	private VariableType varType;
	
	/*
	 * CATARINA:
	 * Mete aqui as cenas da generalização se conseguires, eu depois revejo
	 * 
	 */
	
	public int getTotalConfigurations()	{
		return (int) (Math.ceil(250.0/100)*INDEPENDENT_RUNS*populationSize);
	}
	
}
