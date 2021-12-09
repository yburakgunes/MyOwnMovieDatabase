package com.bilgeadam.boost.momdb.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScriptRunner {
	private String path;
	private Statement stmt;
	private ResultSet rS;
	private boolean isExecuted;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean executeCreationStatement(Statement statement, String path) {
		try (BufferedReader bR = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = bR.readLine()) != null) {
				statement.execute(line);
			}
			this.isExecuted = true;
		} catch (Exception e) {
			e.printStackTrace();
			this.isExecuted = false;
		}
		return isExecuted;
	}
	
	public ResultSet executeQueries(Statement statement, String path) {
		try (BufferedReader bR = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = bR.readLine()) != null) {
				this.rS = statement.executeQuery(line);
			}
			this.isExecuted = true;
		} catch (Exception e) {
			e.printStackTrace();
			this.isExecuted = false;
		}
		return rS;
	}
	
	
}
