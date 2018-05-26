package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		
		try {
			Scanner s = new Scanner(rfGeneralFile);
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String[] line= nextLine.split(" ");
				
				FitnessOutputList outputList = new FitnessOutputList();
				
				for (int i = 0; i < line.length; i++) {
					outputList.setLabel(labels[i]);

				}

				
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open results .rf file.");
		}
		

	}
}
