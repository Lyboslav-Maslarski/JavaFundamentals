package Arrays.Lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        String[] array1 = line1.split(" ");
        String[] array2 = line2.split(" ");
        int[] numbers1 = new int[array1.length];
        int[] numbers2 = new int[array2.length];
        for (int i = 0; i < array1.length; i++) {
            numbers1[i] = Integer.parseInt(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            numbers2[i] = Integer.parseInt(array2[i]);
        }
        int index = 0;
        boolean areEqual = true;
        int sum = 0;
        if (numbers1.length == numbers2.length) {
            for (int i = 0; i < numbers1.length; i++) {
                if (numbers1[i] != numbers2[i]) {
                    index = i;
                    areEqual = false;
                    break;
                } else {
                    sum += numbers1[i];
                }
            }
        } else if (numbers1.length > numbers2.length) {
            areEqual = false;
            for (int i = 0; i < numbers2.length; i++) {
                if (numbers1[i] != numbers2[i]) {
                    index = i;
                    break;
                } else {
                    index = numbers2.length;
                }
            }
        } else {
            areEqual = false;
            for (int i = 0; i < numbers1.length; i++) {
                if (numbers1[i] != numbers2[i]) {
                    index = i;
                    break;
                } else {
                    index = numbers1.length;
                }
            }
        }
        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}