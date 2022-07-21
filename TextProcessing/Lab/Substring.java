package TextProcessing.Lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        while (b.contains(a)) {
            b = b.replace(a, "");
        }
        System.out.println(b);
    }
}
