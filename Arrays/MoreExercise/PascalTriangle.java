package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] array1 = new int[0];
        for (int i = 1; i <= n; i++) {
            int[] array2 = new int[i];
            for (int j = 0; j < array2.length; j++) {
                if (j == array2.length - 1 || j == 0) {
                    array2[j] = 1;
                } else {
                    array2[j] = array1[j - 1] + array1[j];
                }
            }
            array1 = array2;
            Arrays.stream(array2).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
    }
}
