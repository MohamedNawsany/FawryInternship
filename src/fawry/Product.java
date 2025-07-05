package fawry;
import java.util.*;

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    public boolean isAvailable(int amount) {
        return quantity >= amount;
    }

    public abstract boolean isExpired();
}