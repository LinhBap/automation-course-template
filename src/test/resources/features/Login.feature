Feature: Login test

  Scenario: Login
    Given I open web
    When I enter valid username
    And I enter valid password
    And I click login
    Then The error message is not displayed
    When I click Add new Employee
    And I input Employee Number
    And I input First name
    And I input Middle name
    And I input Last name
    And I select Nationality
    And I select date of birth
    And I select gender
    And I select marital status
    And I select Ethinicity


