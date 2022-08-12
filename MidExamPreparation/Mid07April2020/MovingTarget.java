package MidExamPreparation.Mid07April2020;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Shoot":
                    int power = Integer.parseInt(command[2]);
                    if (0 <= index && index < targets.size()) {
                        targets.set(index, targets.get(index) - power);
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(command[2]);
                    if (0 <= index && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command[2]);
                    if (0 <= index - radius && index + radius < targets.size()) {
                        for (int i = 0; i < 2 * radius + 1; i++) {
                            targets.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }
        }
    }
}
