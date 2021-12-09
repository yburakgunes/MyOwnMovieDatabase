package com.bilgeadam.boost.momdb.resources;

import java.util.ResourceBundle;

public class Resources {
	private static final String MYBUNDLE = Resources.class.getPackageName() + ".utils";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(MYBUNDLE);
	
	public static String getUtils(String key) {
		return RESOURCE_BUNDLE.getString(key);
	}
}
