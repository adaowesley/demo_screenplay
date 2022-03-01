package com.demo.screenplay.actions.authentication;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    static final Target USERNAME = InputField.called("Username");
    static final Target PASSWORD = InputField.called("Password");
    static final Target LOGIN_BUTTON = Button.called("Login");
}
