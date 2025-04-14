package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderAction;

public class HeaderActionSD {
    HeaderAction action=new HeaderAction();
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
       try {
        Thread.sleep(2000);
       } catch (InterruptedException e) {
        e.printStackTrace();
       }
    }
    @When("the user selects {string} as the delivery location {string}")
    public void the_user_selects_as_the_delivery_location(String string, String string2) {
        action.specifyLocation(string, string2);
    }
    @When("the user searches for {string} and clicks on the first product in the results")
    public void the_user_searches_for_and_clicks_on_the_first_product_in_the_results(String string) {
        action.searchPen(string);
    }
    @Then("the user clicks Add to Cart")
    public void the_user_clicks_add_to_cart() {
      action.addtocart();
    }

    
}
