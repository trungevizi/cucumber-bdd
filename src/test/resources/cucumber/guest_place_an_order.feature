Feature: Place an order

  Scenario: Guest user places an order with default payment option
    Given I am a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city   | state | zip   | email |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano  | Texas | 75024 | test@gmail.com |
    And I have an product on the cart
    And I am on the checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully