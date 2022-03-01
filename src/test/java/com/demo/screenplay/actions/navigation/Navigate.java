package com.demo.screenplay.actions.navigation;

import com.demo.screenplay.actions.authentication.LoginPage;
import com.demo.screenplay.actions.catalog.CatalogPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate {
    public static Performable toTheLoginPage() {
        return Open.browserOn(new LoginPage());
    }

    public static Performable toTheCatalogPage() {
        return Open.browserOn(new CatalogPage());
    }
}
