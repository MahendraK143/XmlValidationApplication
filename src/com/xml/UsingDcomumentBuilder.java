package com.xml;
import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

public class UsingDcomumentBuilder {
	public static void main(String[] args) {
		String xmlFile = "C:\\Users\\MAHKOLA\\Documents\\workspace-sts-3.9.9.RELEASE\\XmlValidationApplication\\src\\com\\xml\\employee.xml";
		try {
			//First, we can check if the XML file is well-formed. This can be done by parsing the XML file into a DOM document.
			// Create a new factory to create parsers
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			// Use the factory to create a parser (builder) and use it to parse the document.
			DocumentBuilder builder = dBF.newDocumentBuilder();

			//InputSource is = new InputSource(xmlFile);
			Document doc = builder.parse(new File(xmlFile));
			System.out.println(xmlFile + " is well-formed!");
			}
			catch (Exception e) {
			System.out.println(xmlFile + " isn’t well-formed!");
			e.printStackTrace();
			System.exit(1);
			}
	}
}
