package com.sample.users;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	
	public User() {
		
	}
	
	public User(int id, String fName, String lName, String uName) {
		this.id = id;
		this.firstName = fName;
		this.lastName = lName;
		this.userName = uName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
}
