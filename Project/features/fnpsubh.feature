Feature: FNP_WebsiteAutomation
 @birthday
 Scenario: Buying the Cake for Birthday
 Given user landed on the homepage and clears pop-up
 And user search the cake for Birthday
 When cake is selected for Birthday and added to cart
 Then user hover on the "Offers" and get text 
@title
 Scenario: fetch the title of respective page in Footer
 Given user landed on homepage and move to Footer
 When user move to respective page and fetch URL
 Then user get the text of "Policy Info" 