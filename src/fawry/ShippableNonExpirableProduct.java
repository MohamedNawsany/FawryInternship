package fawry;
import java.util.*;

class ShippableNonExpirableProduct extends NonExpirableProduct implements Shippable {
    private double weight;

    public ShippableNonExpirableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() { return weight; }
}