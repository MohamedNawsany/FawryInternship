package fawry;

import java.util.Calendar;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) {
        // Create expiry date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5); // 5 days from now
        Date futureDate = cal.getTime();

        // Create products
        Product cheese = new ShippableExpirableProduct("Cheese", 100, 5, futureDate, 0.2);
        Product biscuits = new ShippableExpirableProduct("Biscuits", 150, 2, futureDate, 0.7);
        Product tv = new ShippableNonExpirableProduct("TV", 3000, 3, 5.0);
        Product scratchCard = new NonExpirableProduct("Mobile scratch card", 50, 10);

        // Create customer and cart
        Customer customer = new Customer("Ali", 1000);
        Cart cart = new Cart();

        // Add to cart
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        // Checkout
        CheckoutService.checkout(customer, cart);
    }
}
