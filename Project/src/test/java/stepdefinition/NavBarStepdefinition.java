package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NavBarActionsSubh;

public class NavBarStepdefinition {
 NavBarActionsSubh navBarActionsSubh=new NavBarActionsSubh();

@Given("user landed on the homepage and clears pop-up")
public void user_landed_on_the_homepage_and_clears_pop_up() {
  navBarActionsSubh.whereToDeliver();
}
@And("user search the cake for Birthday")
public void user_search_the_cake_for_birthday() {
   navBarActionsSubh.birthdayCakeSearch();
}
@When("cake is selected for Birthday and added to cart")
public void cake_is_selected_for_birthday_and_added_to_cart() {
  navBarActionsSubh.buyTheCake();
}
@Then("user hover on the {string} and get text")
public void user_hover_on_the_and_get_text(String string) {
  navBarActionsSubh.OffersVerification(string);
}
}
