package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FooterActionSubh;

public class FooterStepdefinition {
    FooterActionSubh footerAction=new FooterActionSubh();
@Given("user landed on homepage and move to Footer")
public void user_landed_on_homepage_and_move_to_footer() {
    footerAction.scrollToFooter();
}
@When("user move to respective page and fetch URL")
public void user_move_to_respective_page_and_fetch_url() {
  footerAction.linkVerificationPolicyInfo();;
  footerAction.linkVerificationAboutCompany();
}
@Then("user get the text of {string}")
public void user_get_the_text_of(String string) {
  footerAction.PolicyVerification(string);
}
}

