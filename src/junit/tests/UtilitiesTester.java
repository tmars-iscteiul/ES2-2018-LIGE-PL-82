package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import utilities.ProblemName;
import utilities.XmlReader;

/**
 * JUnit tests utilities 
 * @author skner
 *
 */
public class UtilitiesTester {

	@Test
	public void problemName() {
		ProblemName tester = new ProblemName("problemName");
		assertEquals("problemName", tester.getProblemName());
	}
	
	@Test
	public void xmlReader() {
		XmlReader tester = new XmlReader ("configFileName");
		assertEquals("configFileName", tester.getConfig().getName());
	}

}
