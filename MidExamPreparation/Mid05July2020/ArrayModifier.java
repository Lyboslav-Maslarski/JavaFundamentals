package MidExamPreparation.Mid05July2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            switch (command) {
                case "swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    int temp = array[index1];
                    array[index1] = array[index2];
                    array[index2] = temp;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commandParts[1]);
                    index2 = Integer.parseInt(commandParts[2]);
                    array[index1] = array[index1] * array[index2];
                    break;
                case "decrease":
                    array = Arrays.stream(array).map(e -> e - 1).toArray();
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }
}
