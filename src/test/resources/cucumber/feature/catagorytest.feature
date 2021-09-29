@Catelogue-test
Feature: Catelogue test

  @BVT @REG
  Scenario Outline: User retrieve catagory details giving parameters
    When user send the request to get catalogue details with catagory code "<categoryCode>" having param "<paramID>" and value "<value>"
    Then user should receive "<responseCode>" as the response code
    And user asserts catalogue attribute "<xpath_1>" equal text value of "<xpath_1_val>"
    And user asserts catalogue attribute "<xpath_2>" equal boolean value of "<xpath_2_val>"
    And user asserts catalogue of array object "<xpath_3>" of attribute "<xpath_4>" equal text value of "<xpath_4_val>"
    And user asserts catalogue of array object "<xpath_3>" of attribute "<xpath_5>" contain text value of "<xpath_5_val>"

#    And user insert records to product
    Examples:
      | responseCode |categoryCode|paramID  |value|xpath_1|xpath_1_val   |xpath_2   |xpath_2_val|xpath_3     |xpath_4|xpath_4_val |xpath_5     |xpath_5_val    |
      | 200          |6327        |catalogue|false|/name  |Carbon credits|/canRelist|true       |/promotions |/name  |Gallery     |/description|2x larger image|