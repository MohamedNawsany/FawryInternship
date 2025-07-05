package fawry;
import java.util.*;
class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        List<String> names = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Double> weights = new ArrayList<>();

        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            if (names.contains(name)) {
                int index = names.indexOf(name);
                counts.set(index, counts.get(index) + 1);
            } else {
                names.add(name);
                counts.add(1);
                weights.add(weight);
            }

            totalWeight += weight;
        }

        for (int i = 0; i < names.size(); i++) {
            int count = counts.get(i);
            double totalItemWeight = weights.get(i) * count;

            System.out.printf("%dx %s %.0fg\n", count, names.get(i), totalItemWeight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
