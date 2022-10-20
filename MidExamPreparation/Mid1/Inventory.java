package MidExamPreparation.Mid1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> journal = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!"Craft!".equals(input)) {
            String[] commandParts = input.split(" - ");
            String command = commandParts[0];
            String item = commandParts[1];
            switch (command) {
                case "Collect":
                    if (!journal.contains(item)) {
                        journal.add(item);
                    }
                    break;
                case "Drop":
                    journal.remove(item);
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if (journal.contains(oldItem)) {
                        journal.add(journal.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (journal.contains(item)) {
                        journal.remove(item);
                        journal.add(item);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ", journal));
    }
}
