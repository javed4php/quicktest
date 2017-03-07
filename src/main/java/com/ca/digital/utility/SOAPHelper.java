/**
 * 
 */
package com.ca.digital.utility;

/**
 * @author vinsr05
 *
 */
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.springframework.stereotype.Component;

@SuppressWarnings("restriction")
@Component("soapHelper")
public class SOAPHelper {

	//public static void main(String args[]) {
	@SuppressWarnings("restriction")
	public static String createSoapRequest() {
		String output = "";
		try {
			SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = sfc.createConnection();

			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage sm = mf.createMessage();

			SOAPHeader sh = sm.getSOAPHeader();
			SOAPBody sb = sm.getSOAPBody();
			sh.detachNode();
			QName bodyName = new QName("http://quoteCompany.com", "GetQuote", "d");
			SOAPBodyElement bodyElement = sb.addBodyElement(bodyName);
			setBodyElements(bodyElement);
			System.out.println("\n Soap Request:\n");
			sm.writeTo(System.out);
			System.out.println();
			URL endpoint = new URL("https://dx2ci.ca.com:50001/XISOAPAdapter/MessageServlet");
			SOAPMessage response = connection.call(sm, endpoint);
			// output= response.toString();
			output = response.getContentDescription().toString();
			// System.out.println(response.getContentDescription());
			System.out.println(output);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return output;
	}

	/**
	 * @param bodyElement
	 * @throws SOAPException
	 */
	@SuppressWarnings("restriction")
	private static void setBodyElements(SOAPBodyElement bodyElement) throws SOAPException {
			QName qn = new QName("item");
	      	QName qn1 = new QName("PARTNERID");
	      	QName qn2 = new QName("SYSTEMID");
	      	QName qn3 = new QName("DELETEID");
			QName qn4 = new QName("PARTNERCATEGORY");
			QName qn5 = new QName("PARTNERROLE");
			QName qn6 = new QName("PARTNERFUNCTION");
			QName qn7 = new QName("NAME1");
			QName qn8 = new QName("NAME2");
			QName qn9 = new QName("NAME3");
			QName qn10 = new QName("NAME4");
			QName qn11 = new QName("INTERNATIONALLOCATIONNUM1");
			QName qn12 = new QName("INTERNATIONALLOCATIONNUM2");
			QName qn13 = new QName("CHECKDIGIT");
			QName qn14 = new QName("CITY");
			QName qn15 = new QName("ZIP");
			QName qn16 = new QName("STREET");
			QName qn17 = new QName("COUNTRY");
			QName qn18 = new QName("STATE");
			QName qn19 = new QName("ZTIMEZONE");
			QName qn20 = new QName("INTERNATIONALADDRESSVER");
			QName qn21 = new QName("FROMDATE");
			QName qn22 = new QName("TODATE");
			QName qn23 = new QName("SEARCHTERM1");
			QName qn24 = new QName("SEARCHTERM2");
			QName qn25 = new QName("DISTRICT");
			QName qn26 = new QName("REGION");
			QName qn27 = new QName("ADDRESSNUM");
	      
	      SOAPElement quotation = bodyElement.addChildElement(qn);	     
	    		  quotation.addTextNode("");
	      quotation= bodyElement.addChildElement(qn1);
	      quotation.addTextNode("0339792A17PEU");
	      quotation = bodyElement.addChildElement(qn2);
	      quotation.addTextNode("ZCA_ECOMM");
	      quotation = bodyElement.addChildElement(qn3);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn4);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn5);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn6);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn7);
	      quotation.addTextNode("Osama Bin Laden");
	      quotation = bodyElement.addChildElement(qn8);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn9);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn10);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn11);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn12);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn13);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn14);
	      quotation.addTextNode("Islandia");
	      quotation = bodyElement.addChildElement(qn15);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn16);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn17);
	      quotation.addTextNode("USA");
	      quotation = bodyElement.addChildElement(qn18);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn19);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn20);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn21);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn22);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn23);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn24);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn25);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn26);
	      quotation.addTextNode("?");
	      quotation = bodyElement.addChildElement(qn27);
	      quotation.addTextNode("?");
	}
}
