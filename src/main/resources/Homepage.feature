Feature: Homepage sauce demo
  Background: Homepage Sauce Demo page
    Given Im in sauce demo web page

    @VerifyLogout
    Scenario: Logout from homepage
      Given I set the user name field as "standard_user"
      And I set the password field as "secret_sauce"
      When I click on login button
      Then The home page should be displayed
      When I click on menu button
      And I click on logout button
      Then The url should be the login page url
      
    @VerifyCartNumber
    Scenario: Cart number should increase when added product
      Given I set the user name field as "standard_user"
      And I set the password field as "secret_sauce"
      When I click on login button
      Then The home page should be displayed
      When I add the backpack to cart
      Then Cart number should increase
      
    @VerifyPriceLowToHighFilter
    Scenario: Verify price low to high filter works
      Given I set the user name field as "standard_user"
      And I set the password field as "secret_sauce"
      When I click on login button
      Then The home page should be displayed
      When I select the "Price (low to high)" filter
      Then Products should be ordered Low to High Pricewise