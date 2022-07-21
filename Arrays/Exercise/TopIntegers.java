package Arrays.Exercise;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] array = line.split(" ");
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            boolean topInteger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                } else {
                    topInteger = false;
                }
            }
            if (topInteger) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
