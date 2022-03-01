package com.demo.screenplay.actions.authentication;

import com.demo.screenplay.model.Customer;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login {

    public static Performable as(Customer customer) {
        return withCredentials(customer.getUsername(), customer.getPassword());
    }

    public static Performable withCredentials(String username, String password) {
        return Task.called("{0} logs in with username" + username
                        + " and password " + password)
                .whereTheActorAttemptsTo(
                        Enter.theValue(username).into(LoginPage.USERNAME),
                        Enter.theValue(password).into(LoginPage.PASSWORD),
                        Click.on(LoginPage.LOGIN_BUTTON)
                );
    }
}
