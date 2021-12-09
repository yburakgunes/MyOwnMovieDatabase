package com.bilgeadam.boost.momdb.main;

import com.bilgeadam.bautils.BAUtils;
import com.bilgeadam.boost.momdb.clientside.menu.MenuItems;
import com.bilgeadam.boost.momdb.globalization.Globalization;

public class MainClass {
	private static MenuItems menuItems = MenuItems.getInstance();
	private static BAUtils baUtils = BAUtils.getInstance();
	
	public static void main(String[] args) {
		Globalization.setLanguageBundle();
		menuItems.showMainMenu(Globalization.getLanguageBundle());
	}
}
