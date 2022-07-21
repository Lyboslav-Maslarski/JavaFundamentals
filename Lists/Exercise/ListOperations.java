package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scan.nextLine().split("\\s+");
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(command[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(command[1]);
                    int indexToInsert = Integer.parseInt(command[2]);
                    if (indexToInsert < numbers.size() && indexToInsert >= 0) {
                        numbers.add(indexToInsert, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(command[1]);
                    if (indexToRemove < numbers.size() && indexToRemove >= 0) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    String direction = command[1];
                    shiftList(numbers, direction, count);
                    break;
            }
            command = scan.nextLine().split("\\s+");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void shiftList(List<Integer> numbers, String direction, int count) {
        if (direction.equals("left")) {
            for (int i = 0; i < count; i++) {
                numbers.add(numbers.get(0));
                numbers.remove(0);
            }
        } else {
            for (int i = 0; i < count; i++) {
                numbers.add(0, numbers.get(numbers.size() - 1));
                numbers.remove(numbers.size() - 1);
            }
        }
    }
}
