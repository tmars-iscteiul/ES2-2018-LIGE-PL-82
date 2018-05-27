package utilities;

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

/**
 * Reads XML files
 * @author skner
 *
 */
public class XmlReader {
	
	private File config;
	
	public XmlReader (String configFileName) {
		this.config = new File(configFileName);
	}
	
	public Administrator load_administrator() {
		String adminName = "";
		String adminEmail = "";
		try {
			//File inputFile = new File(config);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(config);
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Administrator admin = new Administrator(adminName, adminEmail);
		return admin;
	}

	public File getConfig() {
		return config;
	}
	
	
	
	
	
	
	
	
	
}
