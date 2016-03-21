package com.sample.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
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
public class CommentsControllerGetTest {

	@Value("${local.server.port}")
    private int port;
	
	private URL base;
	private static RestTemplate template;
	
	private static int commentId;

	@BeforeClass
	public static void setUp() throws Exception {
		template = new TestRestTemplate();
		
		// Populate server with some data to test for
		User user = new User(1, "Marty", "McFly", "mmcfly");
		Comment comment = new Comment(-1, user, "Test Text");
		comment = CommentsUtil.addComment(comment);
		commentId = comment.getId();
	}
	
	@Test
	public void getComments() throws Exception {
		this.base = new URL("http://localhost:" + port + "/comments");
		
		CommentResponse response = template.getForObject(base.toString(), CommentResponse.class);		
		assertThat(response.getComments().size(), greaterThan(0));
	}
	
	@Test
	public void getComment() throws Exception {
		this.base = new URL("http://localhost:" + port + "/comments/id/" + commentId);
		
		Comment response = template.getForObject(base.toString(), Comment.class);		
		assertThat(response.getId(), equalTo(commentId));
	}	
	
}
