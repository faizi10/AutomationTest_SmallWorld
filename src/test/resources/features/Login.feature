Feature: Login functionality

  Background: The user must be registered
    Given The user is already registered

  Scenario Outline: Login to the system successfully
    Given I am on the login page
    When I enter the user name "<username>"
    And I enter the password "<password>"
    And I click on the login button
    Then I should be logged in successfully

    Examples:
      | username | password    |
      | student  | Password123 |