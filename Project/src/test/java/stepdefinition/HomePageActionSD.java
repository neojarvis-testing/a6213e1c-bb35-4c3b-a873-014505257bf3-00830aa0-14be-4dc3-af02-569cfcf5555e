package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageAction;

public class HomePageActionSD {
    HomePageAction action=new HomePageAction();
    
    
@When("the user selects {string} as the location {string}")
public void the_user_selects_as_the_location(String string, String string2) {
    action.specifyLocation(string, string2);
}
@When("the user clicks on Plants user selects {string}")
public void the_user_clicks_on_plants_user_selects(String string) {
  action.enterlocation(string);
}
@When("the browses through {string} and {string} and {string}")
public void the_browses_through_and_and(String string, String string2, String string3) {
   action.searchplant(string, string2, string3);
}
@Then("the user clicks on Cart {string}")
public void the_user_clicks_on_cart(String string) {
  action.cartverification(string);
}


}
