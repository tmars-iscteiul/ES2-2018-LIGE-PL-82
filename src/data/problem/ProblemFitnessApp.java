package data.problem;

import data.utils.Path;
import data.utils.ReadFromURL;

/**
 * This class will contain the app to evaluate the configuration sent by the user.
 * 
 * @author skner
 *
 */
public class ProblemFitnessApp {

	private String localJarPath;
	
	public ProblemFitnessApp(data.submission.FitnessList fitnessList)	{
		ReadFromURL.downloadFile(fitnessList.getFileURL(), fitnessList.getFitnessName());
		localJarPath = Path.appsFolder + fitnessList.getFitnessName();
	}
	
}
