Feature: Add product to cart

  Scenario: Add product to cart from home page
    Given The user navigates to Amazon.com
    When the user searches for "Alexa"
    And navigates to the second page
    And selects the third item
    And the user adds the item to the cart
    Then the item is added to the cart