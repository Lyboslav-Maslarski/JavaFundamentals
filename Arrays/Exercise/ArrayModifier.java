package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            if (command[0].equals("swap")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                int temp = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = temp;
            } else if (command[0].equals("multiply")) {
                int index1 = Integer.parseInt(command[1]);
                int index2 = Integer.parseInt(command[2]);
                numbers[index1] = numbers[index1] * numbers[index2];
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.printf("%d", numbers[i]);
            } else {
                System.out.printf("%d, ", numbers[i]);
            }
        }
    }
}
