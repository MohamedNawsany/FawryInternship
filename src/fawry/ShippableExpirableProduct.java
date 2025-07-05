package fawry;
import java.util.*;
class ShippableExpirableProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}
