package spring.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import utilities.Paths;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.submission.Submission;
import main.Engine;

/**
 * The main controller for the spring application. 
 * Will serve as a listening server to answer the form submission service, calling the @see Engine to start processes.
 * @author skner
 *
 */
@RestController
public class SpringController {

	@Autowired
	private Engine engine;
	
	/**
	 * For testing purposes, verifies whether the engine is active or not.
	 * @return A test string, saying whether the engine is waiting or working.
	 */
	@RequestMapping("/engine_status")
	public String getListen()	{
		// Just a test class
		return engine.getStatus();
	}
	
	/**
	 * Adds the submission sent by the user to the engine, so it can start the algorithm processes. This method accepts inputs from a certain origin only.
	 * @param submission The submission object, converted directly from the user's submitted JSON.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/send_problem", consumes = "application/json")
	public void addSubmission(@RequestBody Submission submission)	{
		engine.addProblemToQueue(submission);
	}
	
	/**
	 * Adds the submission sent by the user to the @see Engine, so it can start the algorithm processes. This method accepts inputs from any testing origin.
	 * @param submission The @see Submission object, converted directly from the user's submitted JSON.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/send_test_problem")
	public void addTestSubmission(@RequestBody Submission submission)	{
		engine.addProblemToQueue(submission);
	}
	
	/**
	 * Sends results to the chart service, displaying this data to the user.
	 * @param problem The corresponding problem
	 * @return The displaying information
	 */
	@CrossOrigin(origins = "http://localhost:4100")
	@RequestMapping(method = RequestMethod.POST, value = "/request_problem", consumes = "application/plain-text")
	public @ResponseBody ResponseEntity<String> sendResults(@RequestBody String problem) {
		String jsonTxt;
		InputStream is;
		try {
			is = new FileInputStream(Paths.RESULTS_FOLDER+problem+"/"+problem+"_results.json");
			jsonTxt = IOUtils.toString( is );
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open the results json file.");
			return null;
		} catch (IOException e) {
			System.err.println("Cannot open the results json file.");
			return null;
		}
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>(jsonTxt, httpHeaders, HttpStatus.OK);
	}

}
