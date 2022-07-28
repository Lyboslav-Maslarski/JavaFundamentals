package Methods.MoreExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int a = 1;
        int b = 1;
        int c = a + b;
        int d = a + b + c;
        if (num == 1) {
            System.out.println(a);
        } else if (num == 2) {
            System.out.print(a + " ");
            System.out.println(b);
        } else if (num == 3) {
            System.out.print(b + " ");
            System.out.print(a + " ");
            System.out.print(c);
        } else {
            System.out.print(a + " ");
            System.out.print(b + " ");
            System.out.print(c + " ");
            for (int i = 4; i <= num; i++) {
                System.out.print(d + " ");
                a = b;
                b = c;
                c = d;
                d = a + b + c;
            }
        }
    }
}
