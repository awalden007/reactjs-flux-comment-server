Feature: User

  	Scenario: A user is created
    	Given I create a user with first name Test and last name User with user name TestUser
    	When I search for that user with user name TestUser    	
    	Then I should find that new user with user name TestUser
    	
	Scenario: A user already exists
		Given I create a user with first name Test and last name User with user name TestUser
		Then The user should not have been created
		
	Scenario: Deleting the user
		Given I create a user with first name Delete and last name Me with user name DeleteMe
    	When I delete that user with user name DeleteMe
    	Then I should not find that new user with user name DeleteMe