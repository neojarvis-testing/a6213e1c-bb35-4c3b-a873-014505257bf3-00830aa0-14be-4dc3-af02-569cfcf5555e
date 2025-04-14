Feature: FNP
    @mug
    Scenario: Searching for Magic Mug
    When user hovers over personalized section and clicks mugs
    And user enters the location "Bangalore"
    Then user filters the results by magic Mugs and clicks the first result

    @footer
    Scenario: Iterationg over footer section
    When user scrolls down to footer
    Then user clicks on each and every link and navigates back
