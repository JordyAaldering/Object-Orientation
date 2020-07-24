import Items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas van Harskamp, s1007576
 * @author Jordy Aaldering,     s1004292
 */

public class ShoppingCart {
    private List<Item> cart;

    public ShoppingCart () {
        cart = new ArrayList<Item>();
    }

    public void addItem (Item item) {
        cart.add(item);
    }

    public void removeItem (int i) {
        cart.remove(i);
    }

    public Double getPrice () {
        Double price = 0.00;
        List descList = makeDescList();
        for (int i = 0; i < cart.size(); i++) {
            price += cart.get(i).getPrice();
            if (i >= 1) {
                List sub = descList.subList(0, i);
                if (!sub.contains(cart.get(i).getDescription()))
                    price += cart.get(i).getShipping();
            }
        }
        return price;
    }

    private List makeDescList () {
        List<String> descList = new ArrayList<String>();
        for (Item item : cart)
            descList.add(item.getDescription());
        return descList;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Items: ");
        for (int i = 0; i < cart.size(); i++) {
            sb.append(cart.get(i).getDescription());
            if (i < cart.size() - 1)
                sb.append(", ");
        }
        sb.append(".\nPrice: ").append(getPrice()).append(".");
        return sb.toString();
    }
}
