Feature: Creating New Customer Function
  Background: User login successfully
    Given User is on webpage "http://demo.guru99.com/"
    When User enters UserID with "mngr146503" and Password with "zemygYb" and submit Login Button
    Then User logged-in succesfully and navigated to Manager HomePage
  Scenario: Create new customer successfully with valid information
    Given User is on Manager HomePage
    When User navigates to New Customer Page
    And User fills information in the form and click Submit Button
    Then Appears 'Registered Successfully' Message and shows Registered Customer details table
    And Saves Customer ID in external file