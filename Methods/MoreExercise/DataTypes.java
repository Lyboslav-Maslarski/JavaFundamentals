package Methods.MoreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String data = scan.nextLine();
        switch (input) {
            case "int":
                int a = Integer.parseInt(data);
                dataModifier(a);
                break;
            case "real":
                double b = Double.parseDouble(data);
                dataModifier(b);
                break;
            case "string":
                dataModifier(data);
                break;
        }

    }

    private static void dataModifier(int num) {
        System.out.println(num * 2);
    }

    private static void dataModifier(double num) {
        System.out.println(new DecimalFormat("0.00").format(num * 1.5));
    }

    private static void dataModifier(String data) {
        System.out.printf("$%s$", data);
    }
}
