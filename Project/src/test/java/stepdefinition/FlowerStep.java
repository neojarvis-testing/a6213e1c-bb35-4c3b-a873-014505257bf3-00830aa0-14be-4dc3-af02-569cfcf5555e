package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Flowers;

public class FlowerStep {
    Flowers flower = new Flowers();

@When("user hovers over anniversary and clicks on flowers")
public void user_hovers_over_anniversary_and_clicks_on_flowers() {
    flower.clickOnFlowers();
    
}
@And("user enters the location as {string}")
public void user_enters_the_location_as(String string) {
    flower.locationChennai(string);
}
@And("user filters the result by roses")
public void user_filters_the_result_by_roses() {
    flower.clickOnRoses();
    
}
@Then("user clicks the first result and clicks on buy now")
public void user_clicks_the_first_result_and_clicks_on_buy_now() {
    flower.clickOnBuyNow();
}
    
}
