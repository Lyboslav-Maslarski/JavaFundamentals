package MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> lootWithQuantities = new LinkedHashMap<>();
        lootWithQuantities.put("shards", 0);
        lootWithQuantities.put("fragments", 0);
        lootWithQuantities.put("motes", 0);
        boolean notObtained = true;
        while (notObtained) {
            String[] loot = scan.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < loot.length; i += 2) {
                int productQuantity = Integer.parseInt(loot[i]);
                String product = loot[i + 1];
                lootWithQuantities.putIfAbsent(product, 0);
                lootWithQuantities.put(product, lootWithQuantities.get(product) + productQuantity);
                if (product.equals("shards")) {
                    if (lootWithQuantities.get(product) >= 250) {
                        lootWithQuantities.put(product, lootWithQuantities.get(product) - 250);
                        System.out.println("Shadowmourne obtained!");
                        notObtained = false;
                        break;
                    }
                } else if (product.equals("fragments")) {
                    if (lootWithQuantities.get(product) >= 250) {
                        lootWithQuantities.put(product, lootWithQuantities.get(product) - 250);
                        System.out.println("Valanyr obtained!");
                        notObtained = false;
                        break;
                    }
                } else if (product.equals("motes")) {
                    if (lootWithQuantities.get(product) >= 250) {
                        lootWithQuantities.put(product, lootWithQuantities.get(product) - 250);
                        System.out.println("Dragonwrath obtained!");
                        notObtained = false;
                        break;
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : lootWithQuantities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
