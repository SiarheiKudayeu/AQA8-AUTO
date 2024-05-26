Feature: Testing of Contact Us Page

  Background:
    Given set up driver Selenium

  @selenium
  Scenario Outline: : Test sending message positive Selenium
    Given User is on ContactUs Page Selenium
    When I select option from heading element Selenium
    And I set valid mail Selenium
    And I set order ID Selenium
    And enter text on message field Selenium "<text1>"
    And click send button Selenium
    Then I see success message on screen Selenium
    Examples:
      | text1                |
      | Another text for BDD SELENIUM!!! |