Feature:FNPApplication

@searchpen
Scenario Outline: User searches and adds a product to the cart

Given the user is on the homepage
When the user selects "<Location>" as the delivery location "<pincode>"
And the user searches for "<Product>" and clicks on the first product in the results
Then the user clicks Add to Cart
Examples:
    | Location | Product | pincode |
    | Delhi | pen | 110085 |



@searchplant
Scenario Outline: User navigates through plants and verifies content

When the user selects "<Location>" as the location "<pincode>"
And the user clicks on Plants user selects "<Location>"
And the browses through "Lucky Bamboo" and "Jade Plants" and "Money Plants"
Then the user clicks on Cart "<check>"
Examples:
    | Location | pincode | plant1 | plant2 | plant3 | check |
    | Bangalore  | 560001 | Lucky Bamboo | Jade Plants | Money Plants | Continue Gifting |