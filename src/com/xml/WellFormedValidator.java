package com.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.omg.CORBA.SystemException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class WellFormedValidator {
	/**
	 * This is parsing code
	 *
	 * @param xml The input argument to check.
	 * @throws SAXException    If the input xml is invalid
	 *
	 * @throws SystemException Thrown if the input string cannot be read
	 */
	public void validate(String xml) throws SAXException {

		try {
			doValidate(xml);
		} catch (IOException ioe) {
			// throw new SystemException(
			// "Cannot parse input string. Message:" + ioe.getMessage(), ioe);
			ioe.printStackTrace();
		}
	}

	private void doValidate(String xml) throws SAXException, IOException {
		XMLReader parser = XMLReaderFactory.createXMLReader();
		parser.setContentHandler(new DefaultHandler());
		InputSource source = new InputSource(new ByteArrayInputStream(xml.getBytes()));
		parser.parse(source);
	}

	public static void main(String[] args) throws SAXException {
		String xmlFile = "C:\\Users\\MAHKOLA\\Documents\\workspace-sts-3.9.9.RELEASE\\XmlValidationApplication\\src\\com\\xml\\shiporder.xml";
		new WellFormedValidator().validate(xmlFile);
	}

}
