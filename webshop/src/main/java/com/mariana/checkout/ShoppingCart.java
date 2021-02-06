package com.mariana.checkout;

import chat.Observer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    public List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(String code)
    {
        items.removeIf(i -> i.getCode().equals(code));
    }
    public int calculateTotal()
    {
        return items.stream()
                .map(Item::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void pay(PaymentStrategy paypalStrategy)
    {
        paypalStrategy.pay(calculateTotal());
    }
}
