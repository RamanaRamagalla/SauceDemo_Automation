Feature: SauceDemo Inventory Flow

  Scenario: Products page actions
    Given user is on login page
    When user enters username "standard_user" and password "secret_sauce"
    And clicks login button
    Then user should see products page
    When user sorts products by "Price (low to high)"
    And adds first product to cart
    And adds multiple products to cart
    Then cart badge count should reflect the number of products added
