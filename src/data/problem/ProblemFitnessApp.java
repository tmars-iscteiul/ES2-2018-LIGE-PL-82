package data.problem;

import java.util.ArrayList;

import data.submission.FitnessOutputList;
import utilities.Paths;
import utilities.ReadFromURL;

/**
 * This class will contain the app to evaluate the configuration sent by the user.
 * 
 * @author skner
 * 
 */
public class ProblemFitnessApp {

	private class FitnessOutput	{
		private String outputName;
		@SuppressWarnings("unused")
		private String description;
		private FitnessOutput(String outputName, String description) {
			this.outputName = outputName;
			this.description = description;
		}
	}
	
	private String localJarPath;
	private String fitnessAppName;
	private ArrayList<FitnessOutput> fitnessOutputList;
	
	public ProblemFitnessApp(String externalJarPath, int objectiveCount)	{
		if(!externalJarPath.endsWith(".jar"))	{
			localJarPath = Paths.APPS_FOLDER + externalJarPath + ".jar";
		}	else	{
			localJarPath = Paths.APPS_FOLDER + externalJarPath;
		}
		fitnessOutputList = new ArrayList<FitnessOutput>();
		for(int i = 0; i<objectiveCount; i++)	{
			fitnessOutputList.add(new FitnessOutput("Objective #" + (i+1), ""));
		}
		fitnessAppName = externalJarPath;
	}
	
	public ProblemFitnessApp(data.submission.FitnessApp fitnessApp)	{
		String filePath = fitnessApp.getFitnessName();
		if(!filePath.endsWith(".jar"))	{
			filePath += ".jar";
		}
		ReadFromURL.downloadFile(fitnessApp.getFileURL(), filePath);	// Downloads file to caseStudies folder
		localJarPath = Paths.APPS_FOLDER + filePath;
		fitnessOutputList = new ArrayList<FitnessOutput>();
		for(FitnessOutputList fol : fitnessApp.getFitnessOutputList()) {
			fitnessOutputList.add(new FitnessOutput(fol.getOutputName(), fol.getOutputDescription()));
		}

	}

	public String getLocalJarPath() {
		return localJarPath;
	}

	public String getFitnessAppName() {
		return fitnessAppName;
	}

	public ArrayList<FitnessOutput> getFitnessOutputList() {
		return fitnessOutputList;
	}
	
	public int getFitnessOutputListSize() {
		return fitnessOutputList.size();
	}
	
	public String[] getFitnessOutputsAsArray()	{
		String[] res = new String[fitnessOutputList.size()];
		for(int i = 0; i<res.length; i++)	{
			res[i] = fitnessOutputList.get(i).outputName;
		}
		return res;
	}
}
