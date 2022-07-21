package Arrays.Exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        String[] s1 = line1.split(" ");
        String[] s2 = line2.split(" ");
        for (int i = 0; i < s2.length; i++) {
            for (int j = 0; j < s1.length; j++) {
                if (s2[i].equals(s1[j])) {
                    System.out.print(s2[i] + " ");
                }
            }
        }
    }
}
