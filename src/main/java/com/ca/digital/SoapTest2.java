package com.ca.digital;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.w3c.dom.NodeList;

public class SoapTest2 {
	

    static {

       java.net.Authenticator.setDefault(new java.net.Authenticator() {

           @Override
           protected java.net.PasswordAuthentication getPasswordAuthentication() {
               return new java.net.PasswordAuthentication("R3ALEREMOTE", "C0nn3ct1".toCharArray());
           }
       });}
    
     
        public static void main(String[] args) throws Exception
        {
    
            try {
    
                URL url = new URL("http://dx2ci.ca.com:50000/dir/wsdl?p=sa/d78155dc7ceb3c2fa5c78fb56b69b814");
                QName qName = new QName("urn:ca.com:GTS_SPL_Websevice","GTS_SPL_sync_MIService"); //GTS_SPL_sync_MIService -- GTS_SPL_sync_MI
                QName portName = new QName("urn:ca.com:GTS_SPL_Websevice","HTTP_Port");
                Service service = Service.create(url, qName);
                MessageFactory factory = MessageFactory.newInstance();
                SOAPMessage sm = factory.createMessage();
    			SOAPEnvelope envelope = sm.getSOAPPart().getEnvelope();
                envelope.addNamespaceDeclaration("urn", "urn:sap-com:document:sap:rfc:functions"); 
                QName bodyName = envelope.createQName("ZGD_GTS_SPL_WEBRFC", "urn");
                SOAPBody sb = envelope.getBody();
    			QName gts = new QName("GTS_INF");
    			QName item = new QName("item");
    			SOAPBodyElement bodyElement = sb.addBodyElement(bodyName);
    			SOAPElement gtsBody = bodyElement.addChildElement(gts);
    			SOAPElement itemBody = gtsBody.addChildElement(item);
    			setBodyElements(itemBody);

                Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class,
                              Service.Mode.MESSAGE);
                sm.writeTo(System.out);
                  SOAPMessage response = dispatch.invoke(sm);
                  System.out.println(response);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
    
        }

        @SuppressWarnings("restriction")
    	private static SOAPElement setBodyElements(SOAPElement bodyElement) throws SOAPException {
    		
    		QName qn1 = new QName("PARTNERID");
    		QName qn2 = new QName("PARTNERTYPE");
    		QName qn3 = new QName("SYSTEMID");
    		QName qn4 = new QName("DELETEID");
    		QName qn5 = new QName("PARTNERCATEGORY");
    		QName qn7 = new QName("PARTNERROLE");
    		QName qn8 = new QName("PARTNERFUNCTION");
    		QName qn9 = new QName("NAME1");
    		QName qn10 = new QName("NAME2");
    		QName qn11 = new QName("NAME3");
    		QName qn12 = new QName("NAME4");
    		QName qn13 = new QName("INTERNATIONALLOCATIONNUM1");
    		QName qn14 = new QName("INTERNATIONALLOCATIONNUM2");
    		QName qn15 = new QName("CHECKDIGIT");
    		QName qn16 = new QName("CITY");
    		QName qn17 = new QName("ZIP");
    		QName qn18 = new QName("STREET");
    		QName qn19 = new QName("COUNTRY");
    		QName qn20 = new QName("STATE");
    		QName qn21 = new QName("ZTIMEZONE");
    		QName qn22 = new QName("INTERNATIONALADDRESSVER");
    		QName qn23 = new QName("FROMDATE");
    		QName qn24 = new QName("TODATE");
    		QName qn25 = new QName("SEARCHTERM1");
    		QName qn26 = new QName("SEARCHTERM2");
    		QName qn27 = new QName("DISTRICT");
    		QName qn28 = new QName("REGION");
    		QName ADDRESSNUM = new QName("ADDRESSNUM");
    		
    		SOAPElement quotation = bodyElement.addChildElement(qn1);
    		quotation.addTextNode("test_48877");
    		quotation = bodyElement.addChildElement(qn2);
    		quotation.addTextNode("0001");
    		quotation = bodyElement.addChildElement(qn3);
    		quotation.addTextNode("ZCA_STAR");
    		quotation = bodyElement.addChildElement(qn4);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn5);
    		quotation.addTextNode("2");
    		quotation = bodyElement.addChildElement(qn7);
    		quotation.addTextNode("SLLCPC");
    		quotation = bodyElement.addChildElement(qn8);
    		quotation.addTextNode("RS");
    		quotation = bodyElement.addChildElement(qn9);
    		quotation.addTextNode("Osama Bin Laden");
    		quotation = bodyElement.addChildElement(qn10);
    		quotation.addTextNode("OSAMA");
    		quotation = bodyElement.addChildElement(qn11);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn12);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn13);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn14);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn15);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn16);
    		quotation.addTextNode("NEW YORK");
    		quotation = bodyElement.addChildElement(qn17);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn18);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn19);
    		quotation.addTextNode("USA");
    		quotation = bodyElement.addChildElement(qn20);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn21);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn22);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn23);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn24);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn25);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn26);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn27);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(qn28);
    		quotation.addTextNode("");
    		quotation = bodyElement.addChildElement(ADDRESSNUM);
    		quotation.addTextNode("");
    		return quotation;
    	}
	
}
