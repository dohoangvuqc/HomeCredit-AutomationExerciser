Feature: Creating New Account Function
  Background: User login successfully
    Given User is on webpage "http://demo.guru99.com/"
    When User enters UserID with "mngr146503" and Password with "zemygYb" and submit Login Button
    Then User logged-in succesfully and navigated to Manager HomePage
  Scenario: Create new account successfully by using created Customer ID
    Given User is on Manager HomePage
    When User navigates to New Account Page
    And User uses stored CustomerID to fills in the form and select Current Type and fill Initial Deposit with "10000" then click Submit Button
    Then Appears 'Account Generated Successfully' Message and shows Created Account details table
    And Saves Account ID in external file