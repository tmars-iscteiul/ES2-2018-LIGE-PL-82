package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.results.FitnessOutputList;
import data.results.Results;
import data.results.Solutions;
import data.results.SolutionsList;
import utilities.Paths;

public abstract class JSONResultsGenerator {
	
	public static void convertResultsAndSolutionsToJSON(String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels, 
			String[] variablesName, int numberOfVariables) {
		
		JSONResultsGenerator.convertResultsToJSON(
				problemName, description, userEmail, 
				fitnessAppName, processTime, labels, numberOfVariables);
		
		JSONResultsGenerator.convertSolutionsToJSON(
				problemName, description, userEmail, 
				fitnessAppName, processTime, labels, variablesName, numberOfVariables);
	}

	
	private static void convertResultsToJSON (String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels, int numberOfVariables) {
		
		Results results = new Results();
		
		results.setProblemName(problemName);
		results.setProblemDescription(description);
		results.setUserEmail(userEmail);
		results.setOutputsFunction(fitnessAppName);
		results.setProcessTime(processTime);
		results.setSolutionVariblesNumber(numberOfVariables);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		results.setOptimizationDate(dateFormat.format(new Date()));
		
		File rfGeneralFile = 
			new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + "_top.rf");
		
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
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String generalOutputsDirectory = Paths.RESULTS_FOLDER + problemName + "/";
			File dir = new File(generalOutputsDirectory);
			
			if (!dir.exists())
				dir.mkdir();
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new File(generalOutputsDirectory + problemName + "_results.json"), results);
			
		} catch (JsonGenerationException e) {
			System.out.println("Cannot create json file.");
		} catch (JsonMappingException e) {
			System.out.println("Cannot generate json data.");
		} catch (IOException e) {
			System.out.println("Cannot create general file.");
		}
		
	}
	
	private static void convertSolutionsToJSON (String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels, String[] variablesName, int numberOfVariables) {
		
		File rsGeneralFile = 
				new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + "_top.rs");
			
		Solutions solutions = new Solutions();
		
		solutions.setProblemName(problemName);
		solutions.setProblemDescription(description);
		solutions.setUserEmail(userEmail);
		solutions.setOutputsFunction(fitnessAppName);
		solutions.setProcessTime(processTime);
		solutions.setSolutionVariablesNumber(numberOfVariables);
		solutions.setVariablesName(variablesName);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		solutions.setOptimizationDate(dateFormat.format(new Date()));
		solutions.setSolutionsList(new ArrayList<SolutionsList>()); 
		
		try {
			SolutionsList solutionsList = new SolutionsList();
			Scanner s = new Scanner(rsGeneralFile);
			int n = 0;
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String[] valuesStr = nextLine.split(" ");
				double[] values = new double[valuesStr.length];
				
				for (int i = 0; i < valuesStr.length; i++) {
					 values[i] = Double.parseDouble(valuesStr[i]);
				}
				
				solutionsList = new SolutionsList("Solution " + (n+1), values);
				solutions.getSolutionsList().add(solutionsList);
				n++;
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
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(
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
		String[] variablesName = {"HTML_COR","BAYES10","SEX_TEXT","DRUGS_LINK"};
		
		JSONResultsGenerator.convertResultsAndSolutionsToJSON(
				"antiSpamProblem", "Descrição do problema", "tm.alves.rodrigues@gmail.com", 
				"antiSpamProblem", 240, labels, variablesName, 300);
		
	}
}
