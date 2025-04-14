Feature: FNP Flower

    @rose
    Scenario: Searching for roses
    When user hovers over anniversary and clicks on flowers 
    And user enters the location as "Chennai"
    And user filters the result by roses
    Then user clicks the first result and clicks on buy now

    @hamper
    Scenario: Searching for Healthy Hampers
    When user hovers over combos and clicks on Healthy Hampers
    And user enters the city as "Bangalore"
    Then user filters the result by availability true
