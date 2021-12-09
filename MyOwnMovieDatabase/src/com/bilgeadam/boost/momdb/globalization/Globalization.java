package com.bilgeadam.boost.momdb.globalization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.bilgeadam.bautils.BAUtils;
import com.bilgeadam.boost.momdb.clientside.menu.MenuItems;

public class Globalization {
	
	private static ResourceBundle languageBundle;
	private static Scanner scanner = new Scanner(System.in);
	private static Locale locale;
	
	private static ResourceBundle languageBundleTr() {
		locale = new Locale("tr");
		ResourceBundle languageBundleTr = ResourceBundle.getBundle("com.bilgeadam.boost.momdb.globalization.texts", locale);
		return languageBundleTr;
	}
	
	private static ResourceBundle languageBundleEn() {
		locale = new Locale("en");
		ResourceBundle languageBundleEn = ResourceBundle.getBundle("com.bilgeadam.boost.momdb.globalization.texts", locale);
		return languageBundleEn;
	}
	
		
	public static ResourceBundle getLanguageBundle() {
		return languageBundle;
	}
	
	public static void setLanguageBundle() {
		ResourceBundle bundle = Globalization.languageBundleEn();
		int choice = 0;
		
		BAUtils baUtils = BAUtils.getInstance();
		baUtils.header(bundle.getString("Globalization.WELCOME"));
		
		MenuItems menuItems = MenuItems.getInstance();
		
		do {
			baUtils.menuBodyCreator(menuItems.getLanQueryList(), "Please Make Your Language Selection");
			choice = scanner.nextInt();
			if (choice < 0 || choice > 2)
				System.out.println(bundle.getString("Globalization.INVALIDENTRY"));
			
		} while (choice < 0 || choice > 2);
		
		switch (choice) {
			case 1:
				bundle = Globalization.languageBundleTr();
				break;
			case 2:
				bundle = Globalization.languageBundleEn();
				break;
			
			default:
				throw new IllegalStateException("Unexpected value: " + choice);
		}
		Globalization.languageBundle = bundle;
	}
	
}
