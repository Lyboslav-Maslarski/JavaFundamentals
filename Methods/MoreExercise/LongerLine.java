package Methods.MoreExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int x3 = Integer.parseInt(scan.nextLine());
        int y3 = Integer.parseInt(scan.nextLine());
        int x4 = Integer.parseInt(scan.nextLine());
        int y4 = Integer.parseInt(scan.nextLine());
        longerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static void longerLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double line1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double line2 = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
        if (line1 >= line2) {
            if (Math.abs(x1) + Math.abs(y1) < Math.abs(x2) + Math.abs(y2)) {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            }
        } else {
            if (Math.abs(x3) + Math.abs(y3) < Math.abs(x4) + Math.abs(y4)) {
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
            }
        }
    }
}
