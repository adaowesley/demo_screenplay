package com.demo.screenplay.actions.catalog;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class CatalogPage extends PageObject {

    public static final Target CATALOG_LIST = PageElement.called("inventory_list");

    public static final Question<Boolean> CATALOG_LIST_IS_VISIBLE = Visibility.of(CATALOG_LIST).asBoolean();

    public static Target addToCartButtonFor(String item) {
        return Button.called("Add to cart")
                .inside(PageElement.called("inventory_item").containingText(item));
    }

    public static Question<Integer> cartCount() {
        return Text.of(PageElement.called("shopping_cart_badge")).asInteger();
    }
}
