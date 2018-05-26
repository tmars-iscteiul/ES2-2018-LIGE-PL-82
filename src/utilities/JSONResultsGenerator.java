package utilities;

import java.io.File;

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
		
		File rfFile = new File(Paths.EXPERIMENTS_FOLDER + problemName + Paths.REFERENCE_FRONTS + problemName + ".rf");
		ArrayList<Double> valueList= new ArrayList<>() ;
		try {
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String nextLine = s.nextLine();
				String [] line= nextLine.split(" ");
				double fp= Double.parseDouble(line[0]);
				double fn= Double.parseDouble(line[1]);
				FPList.add(fp);
				FNList.add(fn);

				//value of the point closest to the center in order to fulfill the requirements of the mixed mail box
				double value= Math.sqrt(Math.pow(fp, 2)+Math.pow(fn, 2) );
				valueList.add(value);
				
			}
			s.close();
		} catch (FileNotFoundException e) {
			AOptionPane.showMessageDialog(
					null, "File not found. Confirm the optimizer file.", "Error", AOptionPane.ERROR_MESSAGE);
		}
		
		chosenValueIndex= findMinIndex(valueList);
	}
}
