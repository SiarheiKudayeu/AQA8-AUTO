Feature: Testing of Contact Us Page

  Scenario: Test sending message positive
    Given User is on ContactUs Page
    When I select option from heading element
    And I set valid mail
    And I set order ID
    And enter text on message field
    And click send button
    Then I see success message on screen

  Scenario: Test sending message positive2
    Given User is on ContactUs Page
    When I select option from heading element
    And I set valid mail
    And I set order ID
    And enter text on message field
    And click send button
    Then I see success message on screen
