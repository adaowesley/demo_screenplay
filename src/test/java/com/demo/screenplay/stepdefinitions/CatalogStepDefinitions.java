package com.demo.screenplay.stepdefinitions;

import com.demo.screenplay.actions.cart.AddToCart;
import com.demo.screenplay.actions.catalog.CatalogPage;
import com.demo.screenplay.actions.navigation.Navigate;
import com.google.common.base.Splitter;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CatalogStepDefinitions {

    @ParameterType(".*")
    public List<String> items(String itemList) {
        return Splitter.on(",").trimResults().splitToList(itemList);
    }

    @When("{actor} is browsing the product catalog")
    public void browsingTheProductCatalog(Actor actor) {
        actor.attemptsTo(Navigate.toTheCatalogPage());
    }

    @When("{actor} adds the following items to the cart: {items}")
    public void addsItemsToTheCart(Actor actor, List<String> items) {
        items.forEach(
                item -> actor.attemptsTo(AddToCart.item(item))
        );
    }

    @Then("the cart item count should be {int}")
    public void theCartItemCountShouldBe(int itemCount) {
        theActorInTheSpotlight().should(
                seeThat(CatalogPage.cartCount(), is(itemCount))
        );
    }
}