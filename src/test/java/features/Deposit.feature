Feature: Deposit Function
  Background: User login successfully
    Given User is on webpage "http://demo.guru99.com/"
    When User enters UserID with "mngr146503" and Password with "zemygYb" and submit Login Button
    Then User logged-in succesfully and navigated to Manager HomePage
  Scenario: Deposit successfully by using created Account ID
    Given User is on Manager HomePage
    When User navigates to Deposit Page
    And User uses stored Account ID to fill in Account No and enters Ammount with "20000" and enters Description with "added 20k" then click Submit Button
    Then Appears 'Transaction details of Deposit for Account No' table
    And Current Balance is 30000