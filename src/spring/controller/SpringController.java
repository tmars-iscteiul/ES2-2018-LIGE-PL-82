/**
 * 
 */
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
	@RequestMapping(method = RequestMethod.POST, value = "/request_problem", consumes = "application/plain-text")
	public @ResponseBody ResponseEntity<String> sendResults(@RequestBody String problem) {
		System.out.println("Requested: " + problem);
		
		String jsonTxt;
		InputStream is;
		
		
		try {
			is = new FileInputStream(Paths.RESULTS_FOLDER+problem+"/"+problem+"_results.json");
			jsonTxt = IOUtils.toString( is );
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open the json file.");
			return null;
		} catch (IOException e) {
			System.out.println("Cannot open the json file.");
			return null;
		}
		
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	    
	    return new ResponseEntity<String>(jsonTxt, httpHeaders, HttpStatus.OK);
	}

}
