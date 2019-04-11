Feature: SimpleCucumberTest

  Scenario:
    Given I open EPAM JDI site
    When I login as user 'PITER_CHAILOVSKII'
    Then User name should be as for user 'PITER_CHAILOVSKII'


