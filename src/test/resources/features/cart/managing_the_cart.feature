Feature: Managing the cart

  Background:
    Given Mark has logged onto the application

  Rule: Customer can add to the catalog

    Scenario Outline: Mark adds items to the cart
      Given Mark is a registered user
      Given Mark is browsing the product catalog
      When Mark adds the following items to the cart: <Items>
      Then the cart item count should be <Item Count>
      Examples:
        | Items                                      | Item Count |
        | Sauce Labs Backpack                        | 1          |
        | Sauce Labs Backpack, Sauce Labs Bike Light | 2          |
