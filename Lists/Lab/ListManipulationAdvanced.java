package Lists.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String[] line = scan.nextLine().split(" ");
        for (String s : line) {
            numbers.add(Integer.parseInt(s));
        }
        String[] command = scan.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOrOdd(numbers, command[1]);
                    break;
                case "Get":
                    System.out.println(sumAllElements(numbers));
                    break;
                case "Filter":
                    filteredList(numbers, command[1], Integer.parseInt(command[2]));
                    break;
            }
            command = scan.nextLine().split(" ");
        }
    }

    private static void filteredList(List<Integer> numbers, String s, int num) {
        List<Integer> filteredList = new ArrayList<>();
        if (s.equals(">")) {
            for (Integer number : numbers) {
                if (number > num) {
                    filteredList.add(number);
                }
            }
        } else if (s.equals(">=")) {
            for (Integer number : numbers) {
                if (number >= num) {
                    filteredList.add(number);
                }
            }
        } else if (s.equals("<")) {
            for (Integer number : numbers) {
                if (number < num) {
                    filteredList.add(number);
                }
            }
        } else {
            for (Integer number : numbers) {
                if (number <= num) {
                    filteredList.add(number);
                }
            }
        }
        for (Integer number : filteredList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static int sumAllElements(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static void printEvenOrOdd(List<Integer> numbers, String s) {
        List<Integer> numbersToPrint = new ArrayList<>();
        if (s.equals("even")) {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    numbersToPrint.add(number);
                }
            }
        } else {
            for (Integer number : numbers) {
                if (number % 2 != 0) {
                    numbersToPrint.add(number);
                }
            }

        }
        for (Integer num : numbersToPrint) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
