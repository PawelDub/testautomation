Feature: Test of content AddToYourOrder page

  @wordpress @Login
  Scenario: Checking of CartSubtotal content
    Given User is on wordpress website "https://wordpress.com"
    When User clicks to login
    Then User is on first login page
    When User enter email and press Continue
    Then User is on second page password
    When User enter password and press LogIn
    Then User is on main login page
    When User press avatar
    Then User is personal page
    Then User is click notification
    When User press checkbox
    Then Checkbox is unselected

  @sanity @regression @Datatable @titleWebsiteUser
  Scenario: Check the title of website - www.softpost.org
    Given website title as tutorial home page of the
      | website | http://www.softpost.org |
      | title   | tutorials               |
      | user    | xyz                     |

  @sanity @regression @outlineData
  Scenario Outline: Check the title of website first name and last name
    Given I am on the website "http://www.softpost.org/selenium-test-page"
    Then I verify that I can enter first name as <firstName>
    Then I verifythat I can enter last nam`e as <lastName>

    Examples:
      | firstName | lastName |
      | shoun     | loh      |
      | tim1      | wilson   |