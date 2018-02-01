Feature: Test of content AddToYourOrder page

  @wordpress
  Scenario: Checking of CartSubtotal content
    Given User is on wordpress website
    When User clicks to <login>
    Then User is on first login page
    When User enter email and press Continue
    Then User is on second page passsword
    When User enter password and press <LogIn>
    Then User is on main login page
    When User press avatar
    Then User is personal page
    Then User is click notification
    Then User press checkbox
    When Checkbox is unselected
#    When cos tam sie dzieje

