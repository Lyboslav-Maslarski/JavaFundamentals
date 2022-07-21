package Lists.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<String> party = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] command = scan.nextLine().split(" ");
            String name = command[0];
            if (command[2].equals("going!")) {
                boolean isGoing = true;
                for (String s : party) {
                    if (s.equals(name)) {
                        System.out.printf("%s is already in the list!%n", name);
                        isGoing = false;
                    }
                }
                if (isGoing) {
                    party.add(name);
                }
            } else {
                int ppl = party.size();
                party.removeIf(s -> s.equals(name));
                if (party.size() == ppl) {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        party.forEach(System.out::println);
    }
}
