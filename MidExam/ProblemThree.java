package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] items = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entryPoint = Integer.parseInt(scan.nextLine());
        String typeOfItems = scan.nextLine();
        int entryPointItem = items[entryPoint];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < entryPoint; i++) {
            if ("expensive".equals(typeOfItems)) {
                if (items[i] >= entryPointItem) {
                    leftSum += items[i];
                }
            } else {
                if (items[i] < entryPointItem) {
                    leftSum += items[i];
                }
            }
        }
        for (int i = entryPoint + 1; i < items.length; i++) {
            if ("expensive".equals(typeOfItems)) {
                if (items[i] >= entryPointItem) {
                    rightSum += items[i];
                }
            } else {
                if (items[i] < entryPointItem) {
                    rightSum += items[i];
                }
            }
        }
        if (rightSum > leftSum) {
            System.out.println("Right - " + rightSum);
        } else {
            System.out.println("Left - " + leftSum);
        }
    }
}
