package com.mariana.checkout;

import com.mariana.specialoffers.AmountDiscountCoupon;
import com.mariana.specialoffers.OfferDecorator;
import com.mariana.specialoffers.PercentageDiscountCoupon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    public List<Item> items = new ArrayList<>();
    private OfferDecorator discountCoupon;
    private OfferDecorator upsellDiscount;
    private OfferDecorator bundleDiscount;

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(String code)
    {
        items.removeIf(i -> i.getCode().equals(code));
    }

    public void addCoupon(String couponCode) {
        if (PercentageDiscountCoupon.couponsAvailable.containsKey(couponCode)) {
            discountCoupon = new PercentageDiscountCoupon(items, couponCode);
            return;
        }
        if (AmountDiscountCoupon.couponsAvailable.containsKey(couponCode)) {
            discountCoupon = new AmountDiscountCoupon(this.items, couponCode);
            return;
        }
        System.out.println("Coupon not available");
    }
    public Double calculateTotal()
    {
        if (discountCoupon != null) {
            return discountCoupon.getPrice();
        }
        return items.stream()
                .map(Item::getPrice)
                .reduce(Double::sum)
                .orElse(-1.0);
    }

    public void pay(PaymentStrategy paypalStrategy)
    {
        paypalStrategy.pay(calculateTotal());
    }
}
