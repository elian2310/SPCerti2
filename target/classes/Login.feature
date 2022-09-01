Feature: Login Sauce Demo
  Background: User login into sauce demo
    Given Im in sauce demo page
    Scenario: Login successfully
      Given I set the user name field as "standard_user"
      And I set the password field as "secret_sauce"
      When I click on login button
      Then The home page should be displayed