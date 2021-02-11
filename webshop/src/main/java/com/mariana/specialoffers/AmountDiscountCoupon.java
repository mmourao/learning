package com.mariana.specialoffers;

import com.mariana.checkout.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmountDiscountCoupon extends OfferDecorator {
    public static final Map<String, Double> couponsAvailable = new HashMap<>();
    static {
        couponsAvailable.put("DISCOUNT5", 5.0);
        couponsAvailable.put("DISCOUNT10", 10.0);
        couponsAvailable.put("AFFILIATE10", 10.0);
        couponsAvailable.put("RETURN5", 5.0);
    }

    List<Item> items;
    String couponCode;

    public AmountDiscountCoupon(List<Item> items, String couponCode) {
        this.items = items;
        this.couponCode = couponCode;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
