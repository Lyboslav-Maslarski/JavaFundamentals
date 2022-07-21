package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double startingBudget = Double.parseDouble(scan.nextLine());
        double budget=startingBudget;
        String input = scan.nextLine();
        boolean outOfMoney = false;
        double totalSpent = 0;
        while (!input.equals("Game Time")) {
            double price = 0;
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    input = scan.nextLine();
                    continue;
            }
            if (budget > price) {
                budget -= price;
                totalSpent += price;
                System.out.printf("Bought %s%n", input);
            } else if (budget == price) {
                System.out.printf("Bought %s%n", input);
                System.out.println("Out of money!");
                totalSpent += price;
                outOfMoney = true;
                break;
            } else {
                System.out.println("Too Expensive");
            }
            input = scan.nextLine();
        }
        if (!outOfMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, startingBudget - totalSpent);
        }
    }
}
