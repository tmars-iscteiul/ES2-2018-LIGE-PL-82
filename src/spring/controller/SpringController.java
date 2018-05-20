/**
 * 
 */
package spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.comm.Email;
import data.comm.EmailSender;
import data.submission.Submission;
import main.Engine;
import utilities.ProblemName;

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
		// Just a test class
		return engine.getStatus();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/send_problem", consumes = "application/json")
	public void addSubmission(@RequestBody Submission submission)	{
		engine.addProblemToQueue(submission);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/send_test_problem")
	public void addTestSubmission(@RequestBody Submission submission)	{
		engine.addProblemToQueue(submission);
	}
	
	@CrossOrigin(origins = "http://localhost:4100")
	@RequestMapping(method = RequestMethod.POST, value = "/request_problem", consumes = "application/json", produces = "application/json")
	public @ResponseBody String sendResults(@RequestBody ProblemName problem) {
		System.out.println("Requested: " + problem.getProblemName());
		
		JSONObject jsonObj;
		String jsonTxt;
		InputStream is;
		
		try {
			is = new FileInputStream("./outputResults/"+problem.getProblemName()+".json");
			jsonTxt = IOUtils.toString( is );
			jsonObj = new JSONObject(jsonTxt);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the json file.");
			return null;
		} catch (IOException e) {
			System.out.println("Cannot open the json file.");
			return null;
		}
		
		return jsonTxt;
	}

}
