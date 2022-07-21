package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int sum = 0;
            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) == 'a' || name.charAt(j) == 'e' || name.charAt(j) == 'o' || name.charAt(j) == 'u' || name.charAt(j) == 'i' ||
                        name.charAt(j) == 'A' || name.charAt(j) == 'E' || name.charAt(j) == 'O' || name.charAt(j) == 'U' || name.charAt(j) == 'I') {
                    sum += name.charAt(j) * name.length();
                } else {
                    sum += name.charAt(j) / name.length();
                }
            }
            sums[i] = sum;
        }
        Arrays.sort(sums);
        Arrays.stream(sums).forEach(e -> System.out.println(e));
    }
}
