package com.mariana.checkout;

import com.mariana.products.SpecialBib;

public class Checkout {
    public static void run() {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new SpecialBib("1234");
        Item item2 = new SpecialBib("5678");

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy());

        //pay by credit card
        cart.pay(new CreditCardStrategy());
    }
}
