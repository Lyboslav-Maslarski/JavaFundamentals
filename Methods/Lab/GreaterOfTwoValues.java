package Methods.Lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String variable = scan.nextLine();
        if (variable.equals("int")) {
            int number1 = Integer.parseInt(scan.nextLine());
            int number2 = Integer.parseInt(scan.nextLine());
            int max = getMax(number1, number2);
            System.out.println(max);
        } else if (variable.equals("string")) {
            String string1 = scan.nextLine();
            String string2 = scan.nextLine();
            String max = getMax(string1, string2);
            System.out.println(max);
        } else if (variable.equals("char")) {
            char symbol1 = scan.nextLine().charAt(0);
            char symbol2 = scan.nextLine().charAt(0);
            char max = getMax(symbol1, symbol2);
            System.out.println(max);
        }
    }

    static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static String getMax(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }

    static char getMax(char a, char b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
