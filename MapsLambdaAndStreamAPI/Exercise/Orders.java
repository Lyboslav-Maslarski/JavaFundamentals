package MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Double> productWithPrice = new LinkedHashMap<>();
        Map<String, Integer> productWithQuantity = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("buy")) {
            String[] product = input.split("\\s+");
            String productName = product[0];
            double productPrice = Double.parseDouble(product[1]);
            int productQuantity = Integer.parseInt(product[2]);
            if (productWithPrice.get(productName) == null) {
                productWithPrice.put(productName, productPrice);
                productWithQuantity.put(productName, productQuantity);
            } else {
                productWithPrice.put(productName, productPrice);
                productWithQuantity.put(productName, productWithQuantity.get(productName) + productQuantity);
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, Double> entry : productWithPrice.entrySet()) {
            double finalPrice = entry.getValue() * productWithQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), finalPrice);
        }
    }
}
