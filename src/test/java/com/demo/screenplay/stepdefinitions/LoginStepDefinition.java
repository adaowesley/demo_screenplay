package com.demo.screenplay.stepdefinitions;

import com.demo.screenplay.actions.authentication.ApplicationPage;
import com.demo.screenplay.actions.errors.ErrorMessage;
import com.demo.screenplay.model.Customer;
import com.demo.screenplay.actions.authentication.Login;
import com.demo.screenplay.actions.catalog.CatalogPage;
import com.demo.screenplay.actions.navigation.Navigate;
import com.demo.screenplay.actions.state.Reset;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class LoginStepDefinition {

    @Given("{actor} is a registered user")
    public void is_a_registered_user(Actor actor) {
        //Call an API and register the user.
        //For now just open the URL
        is_on_the_login_page(actor);
    }

    @When("{actor} logs in using valid credentials")
    public void logs_in_using_valid_credentials(Actor actor) {
        Customer customer = Customer.valueOf(actor.getName());
        actor.attemptsTo(
                Login.as(customer)
        );
    }

    @Then("{actor} should be presented with the catalog")
    public void should_be_presented_with_the_catalog(Actor actor) {
        actor.should(
                seeThat(CatalogPage.CATALOG_LIST_IS_VISIBLE)
        );
    }

    @Given("{actor} is on the login page")
    public void is_on_the_login_page(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage()
        );
    }
    @When("{actor} attempts to login with {string} and {string}")
    public void attempts_to_login_with_and(Actor actor, String username, String password) {
        actor.attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @Then("{actor} should be refused access because: {}")
    public void should_be_refused_access(Actor actor, String outcome) {
        actor.should(
                seeThat(ErrorMessage.DISPLAYED, containsStringIgnoringCase(outcome))
        );
    }

    @Given("her account is blocked")
    public void account_is_blocked() {
        //Here you could call an API to block the customer's account
    }

    @Given("{actor} has logged onto the application")
    public void aRegisteredUser(Actor actor) {
        if (!ApplicationPage.PRIMARY_HEADER.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Open.url("https://www.saucedemo.com"),
                    Login.as(Customer.valueOf(actor.getName()))
            );
        }
    }

    @After
    public void clearSession() {
        theActorInTheSpotlight().attemptsTo(
                Reset.applicationState()
        );
    }
}
