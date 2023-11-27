Feature: Logout functionality

  Background:
    Given I am on the login page
    When I enter the user name "standard_user"
    And I enter the password "secret_sauce"
    And I click on the login button
    #Then I click on ok on the alert dialogue
    Then I should be logged in successfully

  Scenario: Logout to the system successfully
    Given I am on the products page
    When I click on the hamburger icon
    And I click on the logout button
    Then I should be logged out successfully

