Feature: Testing of Contact Us Page

  Background:
    Given set up driver Selenide

  @selenide
  Scenario Outline: : Test sending message positive Selenide
    Given User is on ContactUs Page Selenide
    When I select option from heading element Selenide
    And I set valid mail Selenide
    And I set order ID Selenide
    And enter text on message field Selenide "<text1>"
    And click send button Selenide
    Then I see success message on screen Selenide
    Examples:
      | text1                |
      | Another text for BDD SELENIDE!!!|