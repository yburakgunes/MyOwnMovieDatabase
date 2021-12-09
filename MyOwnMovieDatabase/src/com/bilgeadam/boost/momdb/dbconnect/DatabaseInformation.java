package com.bilgeadam.boost.momdb.dbconnect;

import com.bilgeadam.boost.momdb.resources.Resources;

public class DatabaseInformation {
	private String url;
	private String userName;
	private String password;
	private String forNameData;
	
	public DatabaseInformation() {
		this.url = Resources.getUtils("dbUrl");
		this.userName = Resources.getUtils("dbUserName");
		this.password = Resources.getUtils("dbPassword");
		this.forNameData = Resources.getUtils("dbDriver");
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getForNameData() {
		return forNameData;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setForNameData(String forNameData) {
		this.forNameData = forNameData;
	}
	
}
