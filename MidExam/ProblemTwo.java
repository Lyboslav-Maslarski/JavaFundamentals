package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> friendList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        int numberOfBlacklisted = 0;
        int numberOfLost = 0;

        String input = scan.nextLine();
        while (!"Report".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            if ("Blacklist".equals(command)) {
                String name = commandParts[1];
                if (friendList.contains(name)) {
                    numberOfBlacklisted++;
                    System.out.println(name + " was blacklisted.");
                    friendList.set(friendList.indexOf(name), "Blacklisted");
                } else {
                    System.out.println(name + " was not found.");
                }
            } else if ("Error".equals(command)) {
                int index = Integer.parseInt(commandParts[1]);
                if (validIndex(index, friendList)) {
                    String name = friendList.get(index);
                    if (!name.equals("Lost") && !name.equals("Blacklisted")) {
                        friendList.set(index, "Lost");
                        numberOfLost++;
                        System.out.println(name + " was lost due to an error.");
                    }
                }

            } else if ("Change".equals(command)) {
                int index = Integer.parseInt(commandParts[1]);
                String newName = commandParts[2];
                if (validIndex(index, friendList)) {
                    String oldName = friendList.get(index);
                    friendList.set(index, newName);
                    System.out.println(oldName + " changed his username to " + newName + ".");
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Blacklisted names: " + numberOfBlacklisted);
        System.out.println("Lost names: " + numberOfLost);
        System.out.println(String.join(" ", friendList));
    }

    private static boolean validIndex(int index, List<String> friendList) {
        return 0 <= index && index < friendList.size();
    }
}
