package com.sample.comments;

import java.util.ArrayList;
import java.util.List;

public class CommentResponse {
	
	private ArrayList<Comment> comments;
	
	public CommentResponse() {
		this.comments = CommentsUtil.getComments();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

}
