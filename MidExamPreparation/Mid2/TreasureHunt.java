package MidExamPreparation.Mid2;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> lootBox = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!"Yohoho!".equals(input)) {

            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            if ("Loot".equals(command)) {
                for (int i = 1; i < commandParts.length; i++) {
                    String item = commandParts[i];
                    if (!lootBox.contains(item)) {
                        lootBox.add(0, item);
                    }
                }

            } else if ("Drop".equals(command)) {
                int index = Integer.parseInt(commandParts[1]);
                if (0 <= index && index < lootBox.size()) {
                    String remove = lootBox.remove(index);
                    lootBox.add(remove);
                }

            } else if ("Steal".equals(command)) {
                int countToRemove = Integer.parseInt(commandParts[1]);
                List<String> removedItems = new ArrayList<>();
                for (int i = 0; i < countToRemove; i++) {
                    if (lootBox.isEmpty()) {
                        break;
                    }
                    String remove = lootBox.remove(lootBox.size() - 1);
                    removedItems.add(remove);
                }
                Collections.reverse(removedItems);
                System.out.println(String.join(", ", removedItems));
            }

            input = scan.nextLine();
        }

        if (lootBox.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageTreasureGain = lootBox.stream().mapToInt(String::length).sum() * 1.0 / lootBox.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        }
    }
}