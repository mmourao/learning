package com.mariana.checkout;

public class CreditCardStrategy implements PaymentStrategy
{
    @Override
    public void pay(int amount) {
        String msg = String.format("Client paid %s euros with CREDIT CARD", amount);
        System.out.println(msg);
    }
}
