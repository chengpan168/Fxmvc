package com.eden.fxmvc.ui;

import java.util.LinkedHashMap;
import java.util.Map;


public class ModelMap extends LinkedHashMap<String, Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877975283870909150L;

	public ModelMap() {
	}

	public ModelMap(String attributeName, Object attributeValue) {
		addAttribute(attributeName, attributeValue);
	}



	public ModelMap addAttribute(String attributeName, Object attributeValue) {
		put(attributeName, attributeValue);
		return this;
	}


	public ModelMap addAllAttributes(Map<String, ?> attributes) {
		if (attributes != null) {
			putAll(attributes);
		}
		return this;
	}

	public ModelMap mergeAttributes(Map<String, ?> attributes) {
		if (attributes != null) {
			for (String key : attributes.keySet()) {
				if (!containsKey(key)) {
					put(key, attributes.get(key));
				}
			}
		}
		return this;
	}

	public boolean containsAttribute(String attributeName) {
		return containsKey(attributeName);
	}
}
