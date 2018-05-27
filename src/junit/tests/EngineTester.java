package junit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Engine;

/**
 * Junit tests the engine
 * @author skner
 *
 */
public class EngineTester {

	@Test
	public void test() {
		Engine tester = new Engine();
		assertNotNull(tester.getEngineLogger());
	}

}
