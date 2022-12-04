package FinalExam;

import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> animalsFoodNeeded = new LinkedHashMap<>();
        Map<String, List<String>> animalsAreas = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"EndDay".equals(input)) {
            String[] commandParts = input.split("[: -]+");
            String animalName = commandParts[1];
            int food = Integer.parseInt(commandParts[2]);
            if (input.contains("Add")) {

                String animalArea = commandParts[3];
                animalsFoodNeeded.putIfAbsent(animalName, 0);
                animalsFoodNeeded.put(animalName, animalsFoodNeeded.get(animalName) + food);
                animalsAreas.putIfAbsent(animalArea, new ArrayList<>());
                List<String> listOfAnimals = animalsAreas.get(animalArea);
                if (!listOfAnimals.contains(animalName)) {
                    listOfAnimals.add(animalName);
                }

            } else if (input.contains("Feed")) {
                if (animalsFoodNeeded.containsKey(animalName)) {
                    int newFood = animalsFoodNeeded.get(animalName) - food;
                    if (newFood > 0) {
                        animalsFoodNeeded.put(animalName, newFood);
                    } else {
                        animalsFoodNeeded.remove(animalName);
                        for (List<String> list : animalsAreas.values()) {
                            list.remove(animalName);
                        }
                        System.out.println(animalName + " was successfully fed");
                    }
                }
            }

            input = scan.nextLine();
        }
        System.out.println("Animals:");
        for (Map.Entry<String, Integer> entry : animalsFoodNeeded.entrySet()) {
            System.out.printf(" %s -> %dg%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Areas with hungry animals:");
        for (Map.Entry<String, List<String>> entry : animalsAreas.entrySet()) {
            if (entry.getValue().size() > 0) {
                System.out.printf(" %s: %d%n", entry.getKey(), entry.getValue().size());
            }
        }
    }
}
