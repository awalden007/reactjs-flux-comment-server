package com.sample.users;

public class UsersUtil {

	private UsersUtil() {
		
	}
	
	public static User getUser() {
		Users.getInstance();
		return Users.getUser();
	}
	
	public static User getUserById(int id) {
		Users.getInstance();
		return Users.getUserById(id);
	}
	
	public static User getUserByUserName(String userName) {
		Users.getInstance();
		return Users.getUserByUserName(userName);
	}
	
	public static boolean addUser(String firstName, String lastName, String userName) {
		Users.getInstance();
		return Users.addUser(firstName, lastName, userName);
	}
	
	public static void deleteUser(int userId) {
		Users.getInstance();
		Users.deleteUser(userId);
	}
}
