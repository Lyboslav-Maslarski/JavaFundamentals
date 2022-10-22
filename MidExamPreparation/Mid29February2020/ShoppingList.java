package MidExamPreparation.Mid29February2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            String item = commandParts[1];
            switch (command) {
                case "Urgent":
                    if (!groceries.contains(item)) {
                        groceries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    groceries.remove(item);
                    break;
                case "Correct":
                    String newItem = commandParts[2];
                    if (groceries.contains(item)) {
                        groceries.set(groceries.indexOf(item), newItem);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(item)) {
                        groceries.remove(item);
                        groceries.add(item);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println(String.join(", ", groceries));
    }
}
