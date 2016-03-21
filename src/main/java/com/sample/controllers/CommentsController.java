package com.sample.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.comments.Comment;
import com.sample.comments.CommentResponse;
import com.sample.comments.CommentsUtil;

@RestController
@CrossOrigin
@RequestMapping("/comments")
public class CommentsController {

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CommentResponse getComments() {
		return new CommentResponse();
	}	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CommentResponse addComment(@RequestBody Comment comment) {
		CommentsUtil.addComment(comment);
    	return new CommentResponse();
    }
	
	@CrossOrigin
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Comment getComment(@PathVariable("id") int id) {
		return CommentsUtil.getComment(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/likedBy/{commentId}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CommentResponse addLikedBy(@PathVariable("commentId") int commentId, @PathVariable("userId") int userId) {
		CommentsUtil.addLikedBy(commentId, userId);
		return new CommentResponse();
	}
}
