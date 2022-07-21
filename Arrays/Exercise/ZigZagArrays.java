package Arrays.Exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers1 = new int[n];
        int[] numbers2 = new int[n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] array = line.split(" ");
            if (i % 2 == 0) {
                numbers1[i] = Integer.parseInt(array[0]);
                numbers2[i] = Integer.parseInt(array[1]);
            } else {
                numbers1[i] = Integer.parseInt(array[1]);
                numbers2[i] = Integer.parseInt(array[0]);
            }
        }
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print(numbers2[i] + " ");
        }
    }
}
