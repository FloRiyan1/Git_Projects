package bankautomat.service;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import bankautomat.model.UserKonto;

public class FileAccessService
{
	public void writeToFile(UserKonto konto)
	{
		

		// Create the XML document
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			// Create the root element
			Element rootElement = document.createElement("UserKonto");
			document.appendChild(rootElement);
			
			// Create the username element
			Element usernameElement = createChildElement(document, "Username", konto.getUserLogin());
			rootElement.appendChild(usernameElement);
			
			// Create the password element
			Element passwordElement = createChildElement(document, "Password", konto.getUserPassword());
			rootElement.appendChild(passwordElement);
			
			// Create the kontostand element
			Element kontostandElement = createChildElement(document, "Kontostand", konto.getKontostand());
			rootElement.appendChild(kontostandElement);
			
			// Create the auszug element
			Element auszugElement = document.createElement("Auszug");
			
			// Create the betrag element
			Element betragElement = createChildElement(document, "Betrag", "500");
			auszugElement.appendChild(betragElement);
			
			// Create the uhrzeit element
			Element uhrzeitElement = createChildElement(document, "Uhrzeit", "12:30 PM");
			auszugElement.appendChild(uhrzeitElement);
			
			rootElement.appendChild(auszugElement);
			
			// Write the document to XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filename));
			
			transformer.transform(source, result);
			
			System.out.println("XML file created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Element createChildElement(Document document, String tagName, String textContent) {
		Element element = document.createElement(tagName);
		element.appendChild(document.createTextNode(textContent));
		return element;
	}
	    
	public UserKonto readFromFile(String userLogin)
	{
		UserKonto userKonto = null;

		String folderPath = "path/to/your/folder";
		String searchParameter = "your search parameter";

		File folder = new File(folderPath);
		File[] files = folder.listFiles();
		
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					try {
						FileInputStream fileInputStream = new FileInputStream(file);
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document document = builder.parse(fileInputStream);
						document.getDocumentElement().normalize();
						
						// Process the XML document
						searchInXML(document, searchParameter);
	                        
						fileInputStream.close();
					} catch (IOException | ParserConfigurationException | SAXException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return userKonto;
	}

	private static void searchInXML(Document document, String searchParameter) 
	{
		NodeList nodeList = document.getElementsByTagName("*");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String nodeValue = element.getTextContent();
				
				if (nodeValue.contains(searchParameter)) {
					System.out.println("Found in file: " + document.getDocumentURI());
					System.out.println("Node: " + element.getNodeName());
					System.out.println("Value: " + nodeValue);
					System.out.println();
				}
			}
		}
	}
}
