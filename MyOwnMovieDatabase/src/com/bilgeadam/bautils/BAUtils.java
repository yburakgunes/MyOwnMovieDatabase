package com.bilgeadam.bautils;


import java.util.*;
import java.util.stream.IntStream;

public class BAUtils {
	// To Create a single BAUtils object
	private static BAUtils instance = new BAUtils();
	private static Scanner scan = new Scanner(System.in);
	private static TreeMap<Integer, String> menuItems;
	
	// To avoid BAUtils instantiated, constuctors will set private
	private BAUtils() {
	}
	
	// To access object
	public static BAUtils getInstance() {
		return instance;
	}
	
	public void header(String title) {
		// ===========
		// ** title **
		// ===========
		int len = title.length();
		StringBuilder row = new StringBuilder("");
		
		for (int i = 0; i < (len + 6); i++) {
			row.append("=");
		}
		
		System.err.println("\n\n\t\t" + row);
		System.err.println("\t\t** " + title.toUpperCase() + " **");
		System.err.println("\t\t" + row + "\n");
	}
	
	public void menuBodyCreator(List<String> menuList, String message) {
		int length = 0;
		List<String> menuItems = new ArrayList<>();
		StringBuilder row = new StringBuilder("");
		for (String value : menuList) {
			if (value.length() > length) {
				length = value.length();
			} else if (message.length() > length) {
				length = message.length();
			}
		}
		
		IntStream.range(0, length + 8).mapToObj(i -> "_").forEach(row::append);
		menuItems.add("\t" + row.toString());
		row.setLength(0);
		row.append("\t|");
		IntStream.range(0, ((length - message.length()) / 2) + 3).mapToObj(i -> " ").forEach(row::append);
		row.append(message);
		IntStream.range(0, ((length - message.length()) / 2) + 3).mapToObj(i -> " ").forEach(row::append);
		row.append("|");
		
		menuItems.add(row.toString());
		row.setLength(0);
		row.append("|");
		IntStream.range(0, length + 6).mapToObj(i -> "-").forEach(row::append);
		menuItems.add("\t" + row.toString() + "|");
		for (int i = 0; i < menuList.size(); i++) {
			row.setLength(0);
			row.append("\t| " + (i + 1) + ".) " + menuList.get(i).trim());
			int s = length + 1 - menuList.get(i).length();
			IntStream.range(0, s).mapToObj(j -> " ").forEach(row::append);
			row.append("|");
			menuItems.add(row.toString());
		}
		
		row.setLength(0);
		row.append("\t");
		IntStream.range(0, length + 8).mapToObj(i -> "¯").forEach(row::append);
		menuItems.add(row.toString());
		menuItems.forEach(System.out::println);
		
	}
	
	public void footer(String message) {
		System.out.println("\t\t" + message);
		closeResources();
	}
	
	public int menu(HashMap<Integer, String> menuItems) {
		boolean correctAnswer = false;
		int selection = -1;
		do {
			showMenuItems(menuItems);
			selection = getUserSelection();
			correctAnswer = evaluateAnswer(menuItems, selection);
		} while (!correctAnswer);
		return selection;
	}
	
	private boolean evaluateAnswer(HashMap<Integer, String> menuItems, int selection) {
		return menuItems.containsKey(selection);
	}
	
	private int getUserSelection() {
		return readInt("Lütfen Seçiminizi Yapınız");
	}
	
	private void showMenuItems(TreeMap<Integer, String> menuItems) { // en doğru veri yapısı
		Set<Map.Entry<Integer, String>> items = menuItems.entrySet();
		for (Map.Entry<Integer, String> entry : items) {
			System.out.println("\t(" + entry.getKey() + ") ...." + entry.getValue().trim());
		}
		
	}
	
	private void showMenuItems(HashMap<Integer, String> menuItems) {
		// Set<Map.Entry<Integer, String >> items = menuItems.entrySet();
		ArrayList<Integer> keys = new ArrayList<Integer>(menuItems.keySet());
		Collections.sort(keys);
		for (Integer key : keys) {
			System.out.println("\t(" + key + ") ..." + menuItems.get(key).trim());
		}
		System.out.println();
	}
	
	public String readString(String query) {
		showQuery(query);
		String retVal = scan.nextLine();
		return retVal;
	}
	
	private void showQuery(String query) {
		System.out.print("\t" + query + ": ");
	}
	
	public int readInt(String query) {
		int retVal = Integer.MIN_VALUE;
		showQuery(query);
		retVal = scan.nextInt();
		return retVal;
	}
	
	public int[] readInt(String start, String query, int numElements) {
		showQuery(start + " " + numElements + " " + query + "\n");
		int[] retVal = new int[numElements];
		for (int i = 0; i < numElements; i++) {
			System.out.print((i + 1) + ". değeri giriniz: ");
			retVal[i] = scan.nextInt();
		}
		return retVal;
	}
	
	public double readDouble(String query) {
		double retVal = Double.NEGATIVE_INFINITY;
		showQuery(query);
		retVal = scan.nextDouble();
		return retVal;
	}
	
	public void closeResources() {
		scan.close();
	}
	
	public boolean proceeding(String question, String negativeAnswer) {
		boolean retVal = true;
		
		showQuery(question);
		String answer = scan.next();
		
		retVal = answer.equalsIgnoreCase(negativeAnswer);
		
		return retVal;
	}
	
	/*
	 * public static boolean proceeding(String question, String positiveAnswer) {
	 * return readString(question).equalsIgnoreCase(positiveAnswer);
	 * }
	 */
}
