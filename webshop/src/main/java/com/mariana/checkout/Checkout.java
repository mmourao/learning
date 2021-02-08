package com.mariana.checkout;

public class Checkout {
    public static void run() {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy());

        //pay by credit card
        cart.pay(new CreditCardStrategy());
    }
}
