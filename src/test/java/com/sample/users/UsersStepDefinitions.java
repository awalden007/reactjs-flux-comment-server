package com.sample.users;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class UsersStepDefinitions {

	private User user;
	private boolean userCreated;
	
	@Given("^I create a user with first name (.*) and last name (.*) with user name (.*)$")
    public void create_a_new_user(String firstName, String lastName, String userName) throws Throwable {
		userCreated = UsersUtil.addUser(firstName, lastName, userName);		
    }

    @When("^I search for that user with user name (.*)$")
    public void i_search_for_new_user(String userName) throws Throwable {
        user = UsersUtil.getUserByUserName(userName);
    }
    
    @When("^I delete that user with user name (.*)$")
    public void i_delete_that_user(String userName) throws Throwable {
        user = UsersUtil.getUserByUserName(userName);
        UsersUtil.deleteUser(user.getId());
    }

    @Then("^I should find that new user with user name (.*)$")
    public void user_should_be_found(String userName) throws Throwable {
    	assertTrue(userCreated);
        assertThat(user.getUserName(), is(userName));
    }
    
    @Then("^I should not find that new user with user name (.*)$")
    public void user_should_not_be_found(String userName) throws Throwable {
    	user = UsersUtil.getUserByUserName(userName);
    	assertNull(user);
    }
    
    @Then("^The user should not have been created$")
    public void user_should_be_created() throws Throwable {
    	assertFalse(userCreated);
    }    
    
}
