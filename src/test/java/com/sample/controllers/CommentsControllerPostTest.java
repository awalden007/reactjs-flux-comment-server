package com.sample.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sample.Application;
import com.sample.comments.Comment;
import com.sample.comments.CommentResponse;
import com.sample.comments.CommentsUtil;
import com.sample.users.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class CommentsControllerPostTest {

	@Value("${local.server.port}")
    private int port;
	
	private URL base;
	private static RestTemplate template;	

	private static int commentsSize;
	
	@BeforeClass
	public static void setUp() throws Exception {
		template = new TestRestTemplate();		
		commentsSize = CommentsUtil.getComments().size();
	}	
	
	@Test
	public void addComment() throws Exception {
		this.base = new URL("http://localhost:" + port + "/comments");
		
		User user = new User(3, "Emmet", "Brown", "doc");
		Comment comment = new Comment(-1, user, "Test Text"); // Note that add comment will replace id with proper id	
		CommentResponse response = template.postForObject(base.toString(), comment, CommentResponse.class);		
		assertThat(response.getComments().size(), equalTo((commentsSize  + 1)));
		
		// Now try and fetch the comment which should have the id of the size of the array its stored in
		this.base = new URL("http://localhost:" + port + "/comments/id/" + (commentsSize  + 1));		
		Comment fetchedComment = template.getForObject(base.toString(), Comment.class);		
		assertThat(fetchedComment.getId(), equalTo((commentsSize  + 1)));
		assertThat(fetchedComment.getAuthor().getUserName(), equalTo("doc"));
	}
	
	
}
