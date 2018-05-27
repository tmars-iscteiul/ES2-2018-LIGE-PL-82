package junit.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import utilities.TimeVariable;
import utilities.VariableType;

import org.junit.Test;

import data.problem.Configuration;
import data.problem.Problem;
import data.problem.ProblemFitnessApp;
import data.problem.ProblemInputs;
import data.problem.ProblemIntroduction;
import data.problem.ProblemOptimization;
import data.problem.Restriction;
import data.submission.CreateInputItems;
import data.submission.Faqs;
import data.submission.Feedback;
import data.submission.FitnessApp;
import data.submission.FitnessOutputList;
import data.submission.InputListTable;
import data.submission.Inputs;
import data.submission.InputsNameTable;
import data.submission.Introduction;
import data.submission.MainInformation;
import data.submission.Optimization;
import data.submission.Submission;

/**
 * JUnit tests the class problem
 * @author skner
 *
 */
public class ProblemTester {
	private ProblemIntroduction introduction = new ProblemIntroduction("name", "fullDescription", new TimeVariable (2.0, "sec"), new TimeVariable (10.0, "min"), "test@gmail.com");
	private ProblemInputs inputs = new ProblemInputs(); 
	private ProblemOptimization optimization = new ProblemOptimization(); 
	private ProblemFitnessApp fitnessApp = new ProblemFitnessApp("D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar", 20);
	
	private Introduction subintroduction = new Introduction();
	private MainInformation submainInformation = new MainInformation("problemName", "fullDescription", 10, "sec",30, "min", "userEmail");
	private Inputs subinputs = new Inputs();
	private FitnessApp subfitnessApp=new FitnessApp(null, "fitnessName", "D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar");
	private Optimization suboptimization = new Optimization("optimizerSelection", false, true,
			true, true, false, false, false, false, false, false, false, false, true, false, false, false,
			false, false, false, false, false, false,
			false, false, false, false, false, false,
			false, false, false, false, false, false,
			false, false, false, false);
	private Feedback subfeedback = new Feedback();
	private Faqs subfaqs = new Faqs();
	
	
	@Test
	public void problem() {
		Problem tester = new Problem(null, null, null, null);
		assertNull(tester.getFitnessApp());
		tester.setFitnessApp(fitnessApp);
		tester.setInputs(inputs);
		tester.setIntroduction(introduction);
		tester.setOptimization(optimization);
		assertNotNull(tester.getIntroduction());
		assertNotNull(tester.getFitnessApp());
		assertNotNull(tester.getInputs());
		assertNotNull(tester.getOptimization());
		assertNotNull(tester.getOptimization().getAlgorithmList());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void submission() {
		CreateInputItems create = new CreateInputItems();
		InputsNameTable it = new InputsNameTable("list", "description");
		List<InputsNameTable> lit = new ArrayList<InputsNameTable>();
		lit.add(it);
		create.setInputsNameTable(lit);
		subinputs.setCreateInputItems(create);
		InputListTable ilt = new InputListTable("listName", "type", 20, 2.0, 5.0, "description");
		List<InputListTable> tilt = new ArrayList<InputListTable>();
		tilt.add(ilt);
		subinputs.setInputListTable(tilt);
		subinputs.setRestrictions(null);
		subfeedback.setEmail("email");
		subfeedback.setEmailText("emailText");
		subfeedback.setName("name");
		subfeedback.setSubject("subject");
		Submission sub = new Submission();
		sub.setFaqs(subfaqs);
		sub.setFeedback(subfeedback);
		FitnessOutputList fol = new FitnessOutputList();
		fol.setOutputDescription("outputDescription");
		fol.setOutputName("outputName");
		fol.setOutputType("outputType");
		List<FitnessOutputList> lfol = new ArrayList<FitnessOutputList>();
		lfol.add(fol);
		subfitnessApp.setFitnessOutputList(lfol);
		sub.setFitnessApp(subfitnessApp);
		sub.setInputs(subinputs);
		sub.setIntroduction(subintroduction);
		sub.setMainInformation(submainInformation);
		sub.setOptimization(suboptimization);
		Problem tester2 = new Problem(sub);
	}
	
	@Test
	public void submissionSolo() {
		Submission tester = new Submission(subintroduction, submainInformation, subinputs, subfitnessApp, suboptimization,	subfeedback, subfaqs);
		assertNotNull(tester.getIntroduction());
		assertNotNull(tester.getFaqs());
		assertNotNull(tester.getFeedback());
	}
	
	@Test
	public void configurationSolo() {
		//                         Configuration(String name, double low, double up, String type, int configSize, String description) 
		Configuration tester = new Configuration("name", 1.0, 5.0, "type", 20, "description");
		assertEquals(1.0, tester.getLowerLimit(),0);
		assertEquals(5.0, tester.getUpperLimit(),0);
		tester.setArrayType("int");
		assertEquals(VariableType.varInt,tester.getVarType());
		tester.setArrayType("double");
		assertEquals(VariableType.varDouble,tester.getVarType());
		tester.setArrayType("boolean");
		assertEquals(VariableType.varBoolean,tester.getVarType());
		assertNotNull(tester.getValueArray());
	}
	
	@Test
	public void fitnessAppSolo() {
		assertNotNull(fitnessApp.getLocalJarPath());
		assertNotNull(fitnessApp.getFitnessAppName());
		assertNotNull(fitnessApp.getFitnessOutputList());
		assertNotNull(fitnessApp.getFitnessOutputListSize());
	}
	
	@Test
	public void problemInputsSolo() {
		inputs.addConfiguration("listName", 2.0, 10.0, "type", 20, "description");
		Configuration conf = new Configuration("listNam2e", 3.0, 20.0, "type", 30, "description");
		inputs.addConfiguration(conf);
		inputs.addRestriction("variableName", "symbol", 20);
		Restriction res = new Restriction("variableName2", "symbol2", 30);
		inputs.addRestriction(res);
		assertNotNull(inputs.getConfigList());
	}

}
