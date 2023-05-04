Feature: Place an order in shopping site


  @shopping
  Scenario Outline: verify placing an order Swag Labs shopping site

    Given user open shopping website
    When user login with "<Username>", "<Password>" on Swag Labs
    And user add "<product>" item to cart and verify it
    And user move to Checkout Your Information window and fill FirstName, LastName, "<Zipcode>"
    And user click on Continue button and move to Checkout Overview window and verify it
    Then user click on Finish button and verify Checkout Complete window

    Examples:
      | Username                | Password     | Zipcode | product                           |
      | standard_user           | secret_sauce | N6H2M1  | Sauce Labs Backpack               |
      | standard_user           | secret_sauce | N6H2M1  | Sauce Labs Bike Light             |
      | standard_user           | secret_sauce | N6H2M1  | Sauce Labs Bolt T-Shirt           |
      | standard_user           | secret_sauce | N6H2M1  | Sauce Labs Fleece Jacket          |
      | standard_user           | secret_sauce | N6H2M1  | Sauce Labs Onesie                 |
      | standard_user           | secret_sauce | N6H2M1  | Test.allTheThings() T-Shirt (Red) |
      | problem_user            | secret_sauce | N6H2M1  | Sauce Labs Backpack               |
      | locked_out_user         | secret_sauce | N6H2M1  | Sauce Labs Backpack               |
      | performance_glitch_user | secret_sauce | N6H2M1  | Sauce Labs Backpack               |