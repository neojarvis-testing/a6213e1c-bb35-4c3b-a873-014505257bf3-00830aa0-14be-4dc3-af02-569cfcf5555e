package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CakeFnpActions;

public class Cakestepdefinition {
    CakeFnpActions cakeFnpActions = new CakeFnpActions();

    @Given("User landed in homepage and click on No Thanks and enter data in search bar {string}")
    public void user_landed_in_homepage_and_click_on_no_thanks_and_enter_data_in_search_bar(String string) {

        cakeFnpActions.SearchBar(string);
        cakeFnpActions.deliverToDelhi();
    }

    @And("click on flavour and click on chocolate")
    public void click_on_flavour_and_click_on_chocolate() {

        cakeFnpActions.ClickonFilter();
    }

    @Then("click on first product and click on Buy Now")
    public void click_on_first_product_and_click_on_buy_now() {

        cakeFnpActions.FirstProduct();
    }

}
