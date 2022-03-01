package com.demo.screenplay.actions.cart;

import com.demo.screenplay.actions.catalog.CatalogPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

/**
 * Add one or more items to a cart from the catalog page
 */
public class AddToCart {
    public static Performable item(String item) {
        return Click.on(CatalogPage.addToCartButtonFor(item));
    }

    public static Performable items(List<String> items) {
        return Task.where("{0} adds the following items to the cart: " + items,
                actor -> items.forEach(item -> actor.attemptsTo(AddToCart.item(item)))
        );
    }
}
