package TextProcessing.MoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char start = scan.nextLine().charAt(0);
        char end = scan.nextLine().charAt(0);
        String str = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > start && str.charAt(i) < end) {
                sum += str.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
