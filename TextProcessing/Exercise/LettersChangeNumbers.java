package TextProcessing.Exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strings = scan.nextLine().split("\\s+");
        double totalSum = 0;
        for (String string : strings) {
            char before = string.charAt(0);
            char after = string.charAt(string.length() - 1);
            double number = Double.parseDouble(string.substring(1, string.length() - 1));
            if (Character.isUpperCase(before)) {
                number /= (before - 'A' + 1);
            } else {
                number *= (before - 'a' + 1);
            }
            if (Character.isUpperCase(after)) {
                number -= (after - 'A' + 1);
            } else {
                number += (after - 'a' + 1);
            }
            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);
    }
}
