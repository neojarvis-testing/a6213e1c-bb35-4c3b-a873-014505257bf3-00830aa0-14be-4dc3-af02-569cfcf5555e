package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FnpBusinessAction;

public class BusinessStep {
    FnpBusinessAction bAction = new FnpBusinessAction();

@When("user scrolls down to footer")
public void user_scrolls_down_to_footer() {
    bAction.scrollToFooter();
    
}
@Then("user clicks on each and every link and navigates back")
public void user_clicks_on_each_and_every_link_and_navigates_back() {
    bAction.iterateFnpBusiness();
    bAction.iterateUsefulLinks();
    
}
    
}
