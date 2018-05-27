package junit.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import data.results.FitnessOutputList;
import data.results.Results;

public class ResultsTester {
	
	private double values[] = {2.0, 3.0};
	
	@Test
	public void fitnessOutputList() {
		FitnessOutputList tester = new FitnessOutputList();
		assertNull(tester.getData());
		tester.setLabel("label");
		assertEquals("label", tester.getLabel());
		tester.setData(values);
		assertNotNull(tester.getData());
		
		FitnessOutputList tester2 = new FitnessOutputList("label2", values);
		assertEquals("label2", tester2.getLabel());
	}
	
	@Test
	public void results() {
		Results tester = new Results();
		FitnessOutputList fol = new FitnessOutputList("label", values);
		List<FitnessOutputList> lfol = new ArrayList<FitnessOutputList>();
		lfol.add(fol);
		tester.setFitnessOutputList(lfol);
		assertNotNull(tester.getFitnessOutputList());
		
		String labels[] = {"label1, label2"};
		tester.setLabels(labels);
		assertNotNull(tester.getLabels());
		
		tester.setOptimizationDate("25 maio");
		assertNotNull(tester.getOptimizationDate());
		
		tester.setOutputsFunction("outputsFunction");
		assertNotNull(tester.getOutputsFunction());
		
		tester.setProblemDescription("problemDescription");
		assertNotNull(tester.getProblemDescription());
		
		tester.setProblemName("problemName");
		assertNotNull(tester.getProblemName());
		
		tester.setProcessTime(20);
		assertEquals(20, tester.getProcessTime(),0);
		
		tester.setSolutionVariablesNumber(30);
		assertNotNull(tester.getSolutionVariablesNumber());
		
		tester.setUserEmail("rodolfo.afa@gmail.com");
		assertNotNull(tester.getUserEmail());
		
		Results tester2 = new Results("problemName", "problemDescription", "userEmail", "outputsFunction",
				20, 50, labels, "optimizationDate",
				lfol);
		assertNotNull(tester2.getLabels());
	}

}
