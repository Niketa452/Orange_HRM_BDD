
Feature: User should be able to login successfully

  Background:
    Given User is on homempage
  @login
  Scenario:User should be able to login successfully with valid credentials
    When User enters valid username and password
    And Clicks on login button
    Then User is navigated to Dashboard page

  Scenario Outline:User should not be able to login invalid credentials
    When User enters invalid "<username>" and "<password>"
    And Clicks on login button
    Then "<error message>" should be displayed
    Examples:
      | username | password | error message            |
      | John     | john123  | Invalid credentials      |
      |          | john123  | Username cannot be empty |
      | John     |          | Password cannot be empty |
      |          |          | Username cannot be empty |
      | Admin    | john123  | Invalid credentials      |
      | John     | admin123 | Invalid credentials      |

