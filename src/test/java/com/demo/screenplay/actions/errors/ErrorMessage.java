package com.demo.screenplay.actions.errors;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ErrorMessage extends PageObject {

    public static final Target ERROR_MESSAGE = Target.the("The error message")
            .locatedBy("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public static final Question<String> DISPLAYED = Text.of(ERROR_MESSAGE).asString();
}
