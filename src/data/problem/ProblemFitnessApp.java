package data.problem;

import utilities.Path;
import utilities.ReadFromURL;

/**
 * This class will contain the app to evaluate the configuration sent by the user.
 * 
 * @author skner
 *
 */
public class ProblemFitnessApp {

	private String localJarPath;
	
	public ProblemFitnessApp(data.submission.FitnessOutputList fitnessList)	{
		ReadFromURL.downloadFile(fitnessList.getOutputType(), fitnessList.getOutputName());
		localJarPath = Path.appsFolder + fitnessList.getOutputName();
	}

	public String getLocalJarPath() {
		return localJarPath;
	}
	
	
}
