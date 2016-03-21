package com.sample.comments;

import java.util.ArrayList;

import com.sample.users.User;
import com.sample.users.UsersUtil;

public class CommentsUtil {
	
	private CommentsUtil() {
		
	}
	
	public static Comment addComment(Comment comment) {
		Comments.getInstance();
		comment.setId(Comments.getComments().size() + 1);
		Comments.addComment(comment);
		return comment;
	}
	
	public static ArrayList<Comment> getComments() {
		Comments.getInstance();
		return Comments.getComments();
	}
	
	public static Comment getComment(int id) {
		Comments.getInstance();
		return Comments.getComment(id);
	}
	
	public static void addLikedBy(int commentId, int userId) {
		User user = UsersUtil.getUserById(userId);
		if(user == null) return;
		
		Comment comment = CommentsUtil.getComment(commentId);
		if(comment == null) return;
		
		comment.addLikedBy(user);
	}
}
