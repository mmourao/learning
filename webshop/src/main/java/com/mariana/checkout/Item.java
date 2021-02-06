package com.mariana.checkout;

import com.sun.istack.internal.NotNull;

public class Item
{
    @NotNull
    private final String code;
    private final int price;

    public Item(String code, int price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }
}
