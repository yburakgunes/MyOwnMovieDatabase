package com.bilgeadam.boost.momdb.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private Connection connection;
	private static int connectionCounter;
	private static DatabaseInformation databaseInformation;
	
	private String url = databaseInformation.getUrl();
	private String user = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();
	
	private static DatabaseConnection instance;
	
	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("PostgreSQL Driver Loaded.");
			this.connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database Connected");
			connectionCounter++;
			System.out.println("Database Connection count :" + connectionCounter);
		} catch (Exception e) {
			System.out.println("Database Connection Error..!");
			e.printStackTrace();
		}
	}
	
	static {
		databaseInformation = new DatabaseInformation();
	}
	
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null)
				instance = new DatabaseConnection();
			else if (instance.getConnection().isClosed())
				instance = new DatabaseConnection();
		} catch (Exception e) {
			System.out.println("Singleton Error");
			e.printStackTrace();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();
	}
}
