package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int counter = 0;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            if (input.equals("(") && counter == 0) {
                counter++;
            } else if (input.equals(")") && counter == 1) {
                counter = 0;
            } else if (input.equals("(") || input.equals(")")) {
                System.out.println("UNBALANCED");
                return;
            }
        }
        if (counter != 0) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
