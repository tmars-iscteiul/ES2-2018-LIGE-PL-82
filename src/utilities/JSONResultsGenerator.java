package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.results.FitnessOutputList;
import data.results.Results;
import utilities.Paths;

public abstract class JSONResultsGenerator {

	public static void convertResultsToJSON (String problemName, String description,
			String userEmail, String fitnessAppName, int processTime, String[] labels) {
		
		String generalResultsDirectory = Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS;
		
		Results results = new Results();
		
		results.setProblemName(problemName);
		results.setProblemDescription(description);
		results.setUserEmail(userEmail);
		results.setOutputsFunction(fitnessAppName);
		results.setProcessTime(processTime);
		
		File rfGeneralFile = new File(generalResultsDirectory + problemName + ".rf");
		
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
		
		
		for (int i = 0; i < resultsValues.get(0).length; i++) {
			double[] data = new double[resultsValues.size()];
			String label = "";
			
			if (labels.length > i)
				label = labels[i];
			else label = "undefined";
				
			
			for(int j = 0; j < resultsValues.size(); j++) {
				data[j] = resultsValues.get(i)[j];
			}
			
			results.getFitnessOutputList().add(new FitnessOutputList(label, data));
		}

	}
	

}
