package com.voxworx.polycom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ElementGeneratorInterface {

	/**
	 * Each XML subsection will have a customized element generator<br>
	 * The MAC specific configuration file will be built using a number of these generators
	 * @param dom The master dom
	 * @return The 
	 */
	public Element generateElement(Document dom);
	
}
