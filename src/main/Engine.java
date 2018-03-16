package main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import stakeholders.Administrator;

public class Engine {

	private Administrator admin;
	
	public Engine() {
		
	}
	
	public void load_configuration(String config) {
		String adminName = "";
		String adminEmail = "";
		try {
			File inputFile = new File(config);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			/*System.out.println("\n----- Search the XML document with xpath queries -----");
			// Query 1
			System.out.println("Query 1: ");*/
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("/XML/Administrator/@*");
			NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				if(nl.item(i).getNodeName().equals("Name")) {
					adminName = nl.item(i).getFirstChild().getNodeValue();
				}
				else {
					adminEmail = nl.item(i).getFirstChild().getNodeValue();
				}
				/*System.out.print(nl.item(i).getNodeName() + ":");
				System.out.println(nl.item(i).getFirstChild().getNodeValue() + " ");*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		admin = new Administrator(adminName, adminEmail);
		System.out.println(admin.toString());
	}
}
