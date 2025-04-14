package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MagicMugsAction;

public class MagicMugStep {
    MagicMugsAction mugAction = new MagicMugsAction();

@When("user hovers over personalized section and clicks mugs")
public void user_hovers_over_personalized_section_and_clicks_mugs() {
    mugAction.clickOnMug();
    
}
@And("user enters the location {string}")
public void user_enters_the_location(String string) {
    mugAction.enterLocation(string);
    
}
@Then("user filters the results by magic Mugs and clicks the first result")
public void user_filters_the_results_by_magic_mugs_and_clicks_the_first_result() throws Exception {
    mugAction.results();
    
}
    
}
