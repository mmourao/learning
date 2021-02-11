package com.mariana.specialoffers;

import com.mariana.checkout.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageDiscountCoupon extends OfferDecorator {
    public static final Map<String, Double> couponsAvailable = new HashMap<>();
    static {
        couponsAvailable.put("DISCOUNT10", 0.9);
        couponsAvailable.put("DISCOUNT20", 0.8);
        couponsAvailable.put("AFFILIATE20", 0.8);
        couponsAvailable.put("RETURN10", 0.9);
    }
    List<Item> items;
    String couponCode;

    public PercentageDiscountCoupon(List<Item> items, String couponCode) {
        this.items = items;
        this.couponCode = couponCode;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public Double getPrice() {
        Double total = items.stream()
                .filter(i->!(i instanceof OfferDecorator))
                .map(Item::getPrice)
                .reduce(Double::sum)
                .orElse(-1.0);
        if (total > 0) {
            return total * couponsAvailable.get(this.couponCode);
        }
        throw new RuntimeException("It was not possible to calculate the total amount of your order");
    }
}
