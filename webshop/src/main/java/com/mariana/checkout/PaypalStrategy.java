package com.mariana.checkout;

// Instead of having pay() as a behavior of ShoppingCart we export that behavior to an Interface
public class PaypalStrategy implements PaymentStrategy{
    @Override
    public void pay(Double amount) {
        String msg = String.format("Client paid %s euros with Paypal", amount);
        System.out.println(msg);
    }
}
