/**
 * 
 */
package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.problem.Problem;
import main.Engine;

/**
 * @author skner
 *
 */
@RestController
public class SpringController {

	@Autowired
	private Engine engine;
	
	@RequestMapping("/engine_status")
	public String getListen()	{
		return engine.getStatus();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/problem")
	public void addProblem(@RequestBody Problem problem)	{
		
	}

}
