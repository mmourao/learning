package com.mariana.checkout;

import com.mariana.products.SpecialBib;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void testAddItem()
    {
        Item item = new SpecialBib("abc");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        Assert.assertEquals(1, shoppingCart.items.size());
    }

    @Test
    public void testRemoveItem()
    {
        Item item = new SpecialBib("abc");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        shoppingCart.removeItem(item.getCode());
        Assert.assertEquals(0, shoppingCart.items.size());
    }

    @Test
    public void testCalculateTotal()
    {
        Item item = new SpecialBib("abc");
        Item item2 = new SpecialBib("abd");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);
        Assert.assertEquals((Double)21.8, shoppingCart.calculateTotal());
    }
}
