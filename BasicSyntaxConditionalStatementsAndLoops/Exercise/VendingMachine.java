package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double sum = 0;
        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = scan.nextLine();
        }
        String input2 = scan.nextLine();
        while (!input2.equals("End")) {
            double price = 0;
            switch (input2) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.printf("Invalid product%n");
                    input2 = scan.nextLine();
                    continue;
            }
            if (sum >= price) {
                sum -= price;
                System.out.printf("Purchased %s%n", input2);
            } else {
                System.out.println("Sorry, not enough money");
            }
            input2 = scan.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
