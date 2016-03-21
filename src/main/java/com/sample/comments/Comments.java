package com.sample.comments;

import java.util.ArrayList;

public class Comments {

	private static Comments instance = null;
	
	private static ArrayList<Comment> comments;
	
	protected Comments() {
		comments = new ArrayList<Comment>();
	}
	
	public static Comments getInstance() {
		if(instance == null) {
			instance = new Comments();
		}
		return instance;
	}
	
	public static void addComment(Comment comment) {		
		comments.add(comment);
	}
	
	public static ArrayList<Comment> getComments() {
		return comments;
	}
	
	public static Comment getComment(int id) {
		Comment comment = null;
		for(Comment c : comments) {
			if(c.getId() == id) {
				comment = c;
				break;
			}
		}
		return comment;
	}
	
}
