import com.mariana.checkout.Item;
import com.mariana.checkout.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void testAddItem()
    {
        Item item = new Item("abc", 12);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        Assert.assertEquals(1, shoppingCart.items.size());
    }

    @Test
    public void testRemoveItem()
    {
        Item item = new Item("abc", 12);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        shoppingCart.removeItem(item.getCode());
        Assert.assertEquals(0, shoppingCart.items.size());
    }

    @Test
    public void testCalculateTotal()
    {
        Item item = new Item("abc", 12);
        Item item2 = new Item("abd", 10);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);
        Assert.assertEquals(22, shoppingCart.calculateTotal());
    }
}
