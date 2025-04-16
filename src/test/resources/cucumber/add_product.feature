Feature: Add to cart

    Scenario Outline: Add one product from store
        Given I am on the Store Page
        When I add a "<product_name>" to the cart
        Then I should see 1 "<product_name>" in the cart
        Examples:
            | product_name      |
            | Blue Shoes        |
            | Basic Blue Jeans  |

#    Scenario Outline: Add one product from store - examples
#        Given I am on the Store Page
#        When I add a <product_name> to the cart
#        Then I should see 1 <product_name> in the cart
#        Examples:
#            | product_name      |
#            | Anchor Bracelet   |
#            | Basic Blue Jeans  |