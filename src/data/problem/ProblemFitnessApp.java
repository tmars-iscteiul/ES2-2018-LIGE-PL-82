package data.problem;

import java.util.ArrayList;

import data.submission.FitnessOutputList;
import utilities.Path;
import utilities.ReadFromURL;
import utilities.VariableType;

/**
 * This class will contain the app to evaluate the configuration sent by the user.
 * 
 * @author skner
 * 
 */
public class ProblemFitnessApp {

	private class FitnessOutput	{
		private String outputName;
		private VariableType varType;
		private String description;
		private FitnessOutput(String outputName, VariableType varType, String description) {
			this.outputName = outputName;
			this.varType = varType;
			this.description = description;
		}
	}
	
	private String localJarPath;
	private String fitnessAppName;
	private ArrayList<FitnessOutput> fitnessOutputList;
	
	
	
	public ProblemFitnessApp(data.submission.FitnessApp fitnessApp)	{
		String filePath = fitnessApp.getFitnessName();
		if(!filePath.endsWith(".jar"))	{
			filePath += ".jar";
		}
		ReadFromURL.downloadFile(fitnessApp.getFileURL(), filePath);	// Downloads file to caseStudies folder
		localJarPath = Path.appsFolder + filePath;
		fitnessOutputList = new ArrayList<FitnessOutput>();
		for(FitnessOutputList fol : fitnessApp.getFitnessOutputList()) {
			
			/*
			VariableType auxType;
			if(fol.getOutputType() == "int")
				auxType = VariableType.varInt;
			else if(fol.getOutputType() == "double")	
				auxType = VariableType.varDouble;
			else if(fol.getOutputType() == "boolean")	
				auxType = VariableType.varBoolean;
			else
				auxType = VariableType.varUndefined;
				
				*/
			fitnessOutputList.add(new FitnessOutput(fol.getOutputName(), VariableType.varDouble, fol.getOutputDescription()));
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
	


}
