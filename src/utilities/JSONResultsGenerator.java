package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.results.FitnessOutputList;
import data.results.Results;
import utilities.Paths;

public abstract class JSONResultsGenerator {

	public static void convertResultsToJSON (String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels) {
		
		Results results = new Results();
		
		results.setProblemName(problemName);
		results.setProblemDescription(description);
		results.setUserEmail(userEmail);
		results.setOutputsFunction(fitnessAppName);
		results.setProcessTime(processTime);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		results.setOptimizationDate(dateFormat.format(new Date()));
		
		File rfGeneralFile = 
			new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + ".rf");
		
		List<double[]> resultsValues = new ArrayList<double[]>();
		
		try {
			Scanner s = new Scanner(rfGeneralFile);
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String[] valuesStr = nextLine.split(" ");
				double[] values = new double[valuesStr.length];
				
				for (int i = 0; i < valuesStr.length; i++) {
					 values[i] = Double.parseDouble(valuesStr[i]);
				}
				
				resultsValues.add(values);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open results .rf file.");
		}
		
		results.setFitnessOutputList(new ArrayList<FitnessOutputList>());
		String varLabel = "";
		
		
		for (int i = 0; i < resultsValues.get(0).length; i++) {
			double[] data = new double[resultsValues.size()];
			
			if (labels.length > i)
				varLabel = labels[i];
			else varLabel = "undefined";
			
			for(int j = 0; j < resultsValues.size(); j++)
				data[j] = resultsValues.get(j)[i];
			
			results.getFitnessOutputList().add(new FitnessOutputList(varLabel, data));
		}
		
		String[] globalLabels = new String[resultsValues.size()];
		
		for (int i = 0; i < resultsValues.size(); i++)
			globalLabels[i] = "Solution " + (i+1);			
			
		results.setLabels(globalLabels);
		results.setSolutionVariblesNumber(300);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String generalOutputsDirectory = Paths.RESULTS_FOLDER + problemName + "/";
			File dir = new File(generalOutputsDirectory);
			
			if (!dir.exists())
				dir.mkdir();
			
			mapper.writeValue(
					new File(generalOutputsDirectory + problemName + "_results.json"), results);
			
		} catch (JsonGenerationException e) {
			System.out.println("Cannot create json file.");
		} catch (JsonMappingException e) {
			System.out.println("Cannot generate json data.");
		} catch (IOException e) {
			System.out.println("Cannot create general file.");
		}
		
	}
	
	public static void convertSolutionsToJSON (String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels) {
		
		File rsGeneralFile = 
				new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + ".rs");
			
		List<double[]> resultsValues = new ArrayList<double[]>();
		
		try {
			Scanner s = new Scanner(rsGeneralFile);
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String[] valuesStr = nextLine.split(" ");
				double[] values = new double[valuesStr.length];
				
				for (int i = 0; i < valuesStr.length; i++) {
					 values[i] = Double.parseDouble(valuesStr[i]);
				}
				
				resultsValues.add(values);
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open results .rf file.");
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String generalOutputsDirectory = Paths.RESULTS_FOLDER + problemName + "/";
			File dir = new File(generalOutputsDirectory);
			
			if (!dir.exists())
				dir.mkdir();
			
			mapper.writeValue(
					new File(generalOutputsDirectory + problemName + "_solutions.json"), solutions);
			
		} catch (JsonGenerationException e) {
			System.out.println("Cannot create json file.");
		} catch (JsonMappingException e) {
			System.out.println("Cannot generate json data.");
		} catch (IOException e) {
			System.out.println("Cannot create general file.");
		}
	}
	
	public static void main(String[] args) {
		String[] labels = {"False Positives","False Negatives"};
		JSONResultsGenerator.convertResultsToJSON("antiSpamProblem", "Descrição do problema", "tm.alves.rodrigues@gmail.com", "antiSpamProblem", 240, labels);
	}
}
