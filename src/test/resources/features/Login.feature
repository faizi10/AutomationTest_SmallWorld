Feature: Login functionality

  Scenario: Login to the system successfully
    Given I am on the login page
    When I enter the user name "standard_user"
    And I enter the password "secret_sauce"
    And I click on the login button
    #Then I click on ok on the alert dialogue
    Then I should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter the user name "locked_out_user"
    And I enter the password "secret_sauce"
    And I click on the login button
    Then I should not be able to log in with the following message "Epic sadface: Sorry, this user has been locked out."
