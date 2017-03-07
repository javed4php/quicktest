/**
 * 
 */
package com.ca.digital.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nalch04
 *
 */
public class DigitalConstants {

	private final static String[] DOMAINCHECKPARAMS = {};
	private final static String[] SPLCHECKPARAMS = {};
	private final static String[] CUSTOMERCREATIONPARAMS = {};
	private final static String[] ONPREMPROVISIONPARAMS = {};
	private final static String[] TRANSACTIONPARAMS = {};
	private final static String DOMAINCHECKCLASSNAME="DomainCheckService";
	private final static String SPLCHECKCLASSNAME="SplCheckService";
	private final static String CUSTOMERCREATIONCLASSNAME="CustomerService";
	private final static String TRANSACTIONCLASSNAME="TransactionService";
	private final static String ONPREMPROVISIONCLASSNAME="DomainCheckService";
	public static final Map<String, String[]> PARAMSBYCLASSNAMEMAP = new HashMap<String, String[]>();
	static {
		PARAMSBYCLASSNAMEMAP.put(DOMAINCHECKCLASSNAME, DOMAINCHECKPARAMS);
		PARAMSBYCLASSNAMEMAP.put(SPLCHECKCLASSNAME, SPLCHECKPARAMS);
		PARAMSBYCLASSNAMEMAP.put(CUSTOMERCREATIONCLASSNAME, CUSTOMERCREATIONPARAMS);
		PARAMSBYCLASSNAMEMAP.put(TRANSACTIONCLASSNAME, TRANSACTIONPARAMS);
		PARAMSBYCLASSNAMEMAP.put(ONPREMPROVISIONCLASSNAME, ONPREMPROVISIONPARAMS);
    }
}
