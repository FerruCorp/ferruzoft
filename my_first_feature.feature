Feature: My First Feature
#Imperativo
  #Scenario: My First Scenario
  #  When I navigate to the webapp
  #  And I view details
  #  And I click on the adopt button
  #  And I complete the adoption form
  #  Then I should see "Thank you for adopting a puppy"

  #Scenario: My second Scenario
  #  When I navigate to the webapp
  #  And I view details
  #  And I click on the adopt button
  #  And I complete the adoption form
  #  Then I should see ""

  Scenario Outline: My third Scenario
    When I navigate to the webapp
    And I view details
    And I click on the adopt button
    And I complete the adoption form
    Then I should see "<message>"
    Examples:
    | message                       |
    | Thank you for adopting a puppy|
    |                               |
