/**
 * 
 */
package spring.controller;

import spring.SpringMain;

/**
 * @author skner
 *
 */
public class SpringRunner extends Thread {

	
	@Override
	public void run()	{
		SpringMain.main(null);
	}
	
}
