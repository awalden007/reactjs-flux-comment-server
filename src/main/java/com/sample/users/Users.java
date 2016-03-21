package com.sample.users;

import java.util.ArrayList;
import java.util.Random;

public class Users {

	private static Users instance = null;
	
	private static ArrayList<User> users = null;
	
	protected Users() {
		users = new ArrayList<User>();
		users.add(new User(1, "Marty", "McFly", "mmcfly"));
		users.add(new User(2, "George", "McFly", "gmcfly"));
		users.add(new User(3, "Emmet", "Brown", "doc"));
		users.add(new User(4, "Lorraine", "Baines", "lbaines"));
		users.add(new User(5, "Biff", "Tannen", "biff"));
		users.add(new User(6, "Mr.", "Strickland", "strickland"));
		users.add(new User(7, "Marvin", "Berry", "mberry"));
		users.add(new User(8, "Terrorist", "Van Driver", "vandriver"));
		users.add(new User(9, "The", "Delorean", "timemachine"));
		users.add(new User(10, "Hoverboard", "Girl #1", "hovergirl1"));
		users.add(new User(10, "Hoverboard", "Girl #2", "hovergirl2"));
	}
	
	public static Users getInstance() {
		if(instance == null) {
			instance = new Users();
		}
		return instance;
	}

	public static User getUser() {
		Random random = new Random();
		int ru = random.nextInt(users.size());
		return users.get(ru);
	}
	
	public static User getUserById(int id) {
		User user = null;
		for(User u : users) {
			if(u.getId() == id) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public static User getUserByUserName(String userName) {
		User user = null;
		for(User u : users) {
			if(u.getUserName().equals(userName)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public static boolean addUser(String first, String last, String username) {
		if(getUserByUserName(username) == null) {
			int x = users.size() + 1;
			User user = new User(x, first, last, username);
			users.add(user);
			return true;
		}
		return false;
	}
	
	public static void deleteUser(int userId) {
		User user = getUserById(userId);
		if(user != null) {
			users.remove(user);
		}
	}
}
