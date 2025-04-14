package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LifeStyleFnpActions;

public class LifeStylestepdefinition {
    LifeStyleFnpActions fnpActions = new LifeStyleFnpActions();

    @Given("User landed on homepage and give location {string}")
    public void user_landed_on_homepage_and_give_location(String string) {

        System.out.println(string);
    }

    @And("Hover over LifeStyle and click on Jewellery and click on Rings")
    public void hover_over_life_style_and_click_on_jewellery_and_click_on_rings() {

        fnpActions.NavBar();
        fnpActions.delivertoKolkata();
    }

    @Then("click on add to cart and attach the report")
    public void click_on_add_to_cart_and_attach_the_report() {

        fnpActions.FirstProduct(Hooks.test);
    }

}
