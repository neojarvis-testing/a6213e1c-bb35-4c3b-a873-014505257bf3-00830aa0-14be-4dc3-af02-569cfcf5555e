package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HealthyHampers;

public class HealthyHampersStep {
HealthyHampers hampers = new HealthyHampers();
@When("user hovers over combos and clicks on Healthy Hampers")
public void user_hovers_over_combos_and_clicks_on_healthy_hampers() {
    hampers.healthyHamper();
    
}
@When("user enters the city as {string}")
public void user_enters_the_city_as(String string) {
    hampers.locationBlr(string);
}
@Then("user filters the result by availability true")
public void user_filters_the_result_by_availability_true() {
    hampers.availabilityTrue();
    
}
    
}

