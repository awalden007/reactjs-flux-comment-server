package com.sample.comments;

import java.util.ArrayList;

import com.sample.users.User;

public class Comment {

	private int id;	
	private User author;
	private String text;
	private ArrayList<User> likedBy;
	
	public Comment() {		
		setLikedBy(new ArrayList<User>());
		//this.likedBy.add(new User(1,"Andy","Walden","awalden"));
	}
	
	public Comment(int id, User author, String text) {
		this.id = id;
		this.author = author;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	

	public ArrayList<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(ArrayList<User> likedBy) {
		this.likedBy = likedBy;
	}
	
	public void addLikedBy(User likedByUser) {
		for(User user : this.likedBy) {
			if(user.getId() == likedByUser.getId()) return;
		}
		if(this.author.getId() == likedByUser.getId()) return;
		this.likedBy.add(likedByUser);
	}
	
}
