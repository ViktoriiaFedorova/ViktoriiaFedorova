Feature: SimpleCucumberTest

  Scenario:
    Given I open EPAM JDI site
    When I login as user 'PITER_CHAILOVSKII'
    Then User name should be 'PITER_CHAILOVSKII'

    Given There are needed elements on the Homepage
#     4 pictures, 4 texts under them, 2 texts above (headline and description)

    Given There are needed options under 'Service' in the header
#     Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Performance

    Given There are needed options under 'Service' in the left menu
#     Support, Dates, Complex Table, Simple Table, User Table, Tables With Pages, Different Elements, Performance

    Given I open Different Elements page from header
    Then There are needed elements on the page
#     4 checkboxes, 4 radios, 1 dropdown, 2 buttons, Right Section, Left Section

    When I select 'Water' and 'Wind' checkboxes
    Then There are log rows per each selected checkbox

    When I select 'Selen' radio
    Then There is a log row for selected radio

    When I select 'Yellow' in the dropdown
    Then There is a log row for selected value

    When I unselect 'Water' and 'Wind' checkboxes
    Then There are log rows per each unselected checkbox