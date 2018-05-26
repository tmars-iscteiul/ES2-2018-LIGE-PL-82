package junit.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import data.submission.CreateInputItems;
import data.submission.Feedback;
import data.submission.FitnessApp;
import data.submission.FitnessOutputList;
import data.submission.InputListTable;
import data.submission.Inputs;
import data.submission.InputsNameTable;
import data.submission.MainInformation;
import data.submission.Restrictions;
import data.submission.RestrictionsList;

public class DataSubmissionTester {

	@Test
	public void feedback() {
		Feedback tester = new Feedback("name", "test@gmail.com", "subject", "emailText");
		assertEquals("name",tester.getName());
		assertEquals("test@gmail.com", tester.getEmail());
		assertEquals("subject", tester.getSubject());
		assertEquals("emailText", tester.getEmailText());
	}
	
	@Test
	public void fitnessApp() {
		List<FitnessOutputList> list = null;
		FitnessApp tester = new FitnessApp(list , "fitnessName", "D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar");
		assertEquals("fitnessName", tester.getFitnessName());
		assertNull(tester.getFitnessOutputList());
	}

	@Test
	public void fitnessOutputList() {
		FitnessOutputList tester = new FitnessOutputList("outputName", "D:/Cursos/01 IGE/3ºAno/2º Semestre/Engenharia de Software II/Projecto/ES-2018-IC1-99/target/ES-2018-IC1-99-0.0.1-SNAPSHOT.jar", "outputDescription");
		assertEquals("outputName", tester.getOutputName());
		assertEquals("outputDescription", tester.getOutputDescription());
	}
	
	@Test
	public void inputListTable() {
		InputListTable tester = new InputListTable("listName", "type", 10, 1, 20, "description");
		assertEquals("listName", tester.getListName());
		assertEquals("type", tester.getType());
		assertEquals(10, tester.getNumberVar());
		assertEquals(1, tester.getMinValue());
		assertEquals(20, tester.getMaxValue());
		assertEquals("description", tester.getDescription());
	}
	
	@Test
	public void inputs() {
		List<InputListTable> inputListTable = null;
		List<InputsNameTable> inputsNameTable = null;
		CreateInputItems createInputItems = new CreateInputItems(inputsNameTable);
		List<RestrictionsList> restrictionsList=null;
		Restrictions restrictions = new Restrictions(restrictionsList);
		Inputs tester = new Inputs(inputListTable, createInputItems, restrictions);
		assertNull(tester.getInputListTable());
	}
	
	@Test
	public void mainInformation() {
		MainInformation tester = new MainInformation("problemName", "fullDescription", 2,"averageScale", 20, "maxScale", "userEmail");
		assertEquals("problemName", tester.getProblemName());
	}
	
}
