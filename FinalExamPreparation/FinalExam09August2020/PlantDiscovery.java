package FinalExamPreparation.FinalExam09August2020;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> plantWithRarity = new LinkedHashMap<>();
        Map<String, Double> plantWithRating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantInfo = scan.nextLine().split("<->");
            plantWithRarity.put(plantInfo[0], Integer.parseInt(plantInfo[1]));
            plantWithRating.put(plantInfo[0], 0.0);
        }

        String command = scan.nextLine();
        while (!"Exhibition".equals(command)) {
            String[] commandParts = command.split("[: -]+");
            String plant = commandParts[1];
            if (!plantWithRarity.containsKey(plant)) {
                System.out.println("error");
                command = scan.nextLine();
                continue;
            }
            if (command.contains("Rate")) {
                double rate = Double.parseDouble(commandParts[2]);
                if (plantWithRating.get(plant) == 0) {
                    plantWithRating.put(plant, rate);
                } else {
                    double newRate = (rate + plantWithRating.get(plant)) / 2;
                    plantWithRating.put(plant, newRate);
                }

            } else if (command.contains("Update")) {
                int newRarity = Integer.parseInt(commandParts[2]);
                plantWithRarity.put(plant, newRarity);
            } else if (command.contains("Reset")) {
                plantWithRating.put(plant, 0.0);
            }
            command = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantWithRarity.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), plantWithRating.get(entry.getKey()));
        }
    }
}
