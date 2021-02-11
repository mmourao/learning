package com.mariana.specialoffers;

import com.mariana.checkout.Item;
import com.mariana.checkout.ShoppingCart;
import com.mariana.products.SpecialBib;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PercentageDiscountCouponTest {
    @Test
    public void testGetPrice() {
        Item item = new SpecialBib("abc");
        Item item2 = new SpecialBib("abd");
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        PercentageDiscountCoupon coupon = new PercentageDiscountCoupon(items, "DISCOUNT10");
        Assert.assertEquals((Double)(19.62), coupon.getPrice());
    }
}
