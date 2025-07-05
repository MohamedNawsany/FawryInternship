package fawry;
import java.util.*;
class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;

            if (p.isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired.");
                return;
            }

            if (!p.isAvailable(item.quantity)) {
                System.out.println("Error: " + p.getName() + " is out of stock.");
                return;
            }

            subtotal += item.getTotalPrice();

            if (p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    toShip.add((Shippable) p);
                }
                shipping += ((Shippable) p).getWeight() * item.quantity * 10;
            }
        }

        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        // Deduct balance and quantity
        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.product.decreaseQuantity(item.quantity);
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Customer balance: %.0f\n", customer.getBalance());
    }
}