package it.eng.comuneroma.serviziDipendentiReload.security.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import it.eng.comuneroma.serviziDipendentiReload.security.domain.Dipendente;



public class PersonaXMLParser extends DefaultHandler{

	private String tempVal;
	private String tempAttribute;
	Dipendente tempEmp = null;
	
	public PersonaXMLParser(){
		
	}
	
	public Dipendente getDipendente(byte[] documento) {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
					
			//parse the file and also register this class for call backs			
			sp.parse(new ByteArrayInputStream(documento), this);

		}catch(SAXException se) {
			//logger.error("getDipendente(se) " + se.getMessage());
			tempEmp = null;
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			//logger.error("getDipendente(pce) " + pce.getMessage());
			tempEmp = null;
			pce.printStackTrace();
		}catch (IOException ie) {
			//logger.error("getDipendente(ie) " + ie.getMessage());
			tempEmp = null;
			ie.printStackTrace();
		}
		
		return tempEmp;
	}	
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		
		if(qName.equalsIgnoreCase("persona")) {
			//create a new instance of employee
			tempEmp = new Dipendente();
		}else if(qName.equalsIgnoreCase("anagrafica")) {
			tempAttribute = "anagrafica";
		}else if(qName.equalsIgnoreCase("residenza")) {
			tempAttribute = "residenza";
		}else if(qName.equalsIgnoreCase("altro")) {
			tempAttribute = "altro";
		}		
		
	}	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
		
//		if(tempVal.indexOf("RIUGNN67R15F698H") >-1) {
//			System.out.println(tempVal);
//		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(tempAttribute.equalsIgnoreCase("anagrafica")) {
			if (qName.equalsIgnoreCase("nome")) {
				tempEmp.setNome(tempVal);
			}else if (qName.equalsIgnoreCase("cognome")) {
				tempEmp.setCognome(tempVal);
			}else if (qName.equalsIgnoreCase("sesso")) {
				//tempEmp.set(tempVal);
			}else if (qName.equalsIgnoreCase("provincia")) {
				//tempEmp.set(tempVal);
			}else if (qName.equalsIgnoreCase("descrizione-comune")) {
				//tempEmp.set(tempVal);
			}else if (qName.equalsIgnoreCase("codice-comune")) {
				//tempEmp.set(tempVal);
			}else if (qName.equalsIgnoreCase("data")) {
				//tempEmp.set(tempVal);
			}else if (qName.equalsIgnoreCase("codiceFiscale")) {
				tempEmp.setCodiceFiscale(tempVal);
			}

		}else if(tempAttribute.equalsIgnoreCase("residenza")) {

		}else if(tempAttribute.equalsIgnoreCase("altro")) {
			
			if (qName.equalsIgnoreCase("email")) {
				tempEmp.setEmail(tempVal);
			}else if (qName.equalsIgnoreCase("telefono")) {
				//tempEmp.set(tempVal);
			}
			else if (qName.equalsIgnoreCase("uidChk")) {
				tempEmp.setUsername(tempVal);
			}				
		}
	}	
}
