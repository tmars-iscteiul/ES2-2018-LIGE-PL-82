package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import data.results.FitnessOutputList;

public class ResultsTester {
	
	private double values[] = {2.0, 3.0};
	
	@Test
	public void test() {
		FitnessOutputList tester = new FitnessOutputList();
		assertNull(tester.getData());
		tester.setLabel("label");
		assertEquals("label", tester.getLabel());
		tester.setData(values);
		assertNotNull(tester.getData());
		
		FitnessOutputList tester2 = new FitnessOutputList("label2", values);
		assertEquals("label2", tester2.getLabel());
	}

}
