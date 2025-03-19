@ShoppingCartPage
Feature: JPetStore Shopping Cart

  Background: 
    Given User login to JPetStore with username "Tharun_06" and password "run@1234"

  @PetsInStock
  Scenario: Add product to cart, update quantity, and proceed to checkout if in stock
    When User searches for the pet "Goldfish" and clicks on product ID "FI-FW-02"
    And User clicks on item ID "EST-20"
    And User adds the product to the cart with quantity
    And User checks if the product is in stock
    And If product is available, User updates the quantity to "3" and clicks update cart
    Then User proceeds to checkout
    
   @PetsOutOfStock
   Scenario: Add product to cart and remove if out of stock
    When User searches for the pet "Bulldog" and clicks on product ID "K9-BD-01"
    And User clicks on item ID "EST-6"
    And User adds the product to the cart with quantity
    And User checks if the product is in stock
    And If product is not available, User removes it from the cart
