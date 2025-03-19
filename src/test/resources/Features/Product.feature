@ProductPage
Feature: JPetStore Product Details

  Scenario Outline: Validate and Add Product to Cart
    Given User logged in with username "Tharun_06" and password "run@1234"
    When User clicks on the "<category>" in the home page
    And Clicks on the "<productID>" to view product details
    And Clicks on the "<itemID>" to view item details
    Then Each row data should match with table data like title "<title>", description "<description>", availability "<availability>" and price "<price>"
    And The product image should be visible
    When User adds the product to the cart
    Then The product should be successfully added to the cart

    Examples: 
      | category | productID | itemID | title               | description | availability   | price  |
      | Fish     | FI-FW-02  | EST-20 | Adult Male Goldfish | Goldfish    | 6714 in stock. | $5.50  |
      | Dogs     | K9-BD-01  | EST-6  | Male Adult Bulldog  | Bulldog     | Back ordered.  | $18.50 |