package com.mariana.products;

import com.mariana.checkout.Item;

public class SpecialBib implements Item {
    private final String code;
    public SpecialBib(String code) {
        this.code = code;
    }

    @Override
    public Double getPrice() {
        return 10.90;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
