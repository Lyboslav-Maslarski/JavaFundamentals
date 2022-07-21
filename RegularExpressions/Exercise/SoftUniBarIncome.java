package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^%|$.]*?<(?<product>\\w+)>[^%|$.]*?\\|(?<quantity>\\d+)\\|[^%|$.]*?(?<price>[\\d.]+)\\$");
        /*String clientReg = "%[A-Z][a-z]+%";
        String productReg = "<\\w+>";
        String quantityReg = "\\|\\d+\\|";
        String priceReg = "\\d+[.]?\\d+\\$";*/
        double totalIncome = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"),
                        Integer.parseInt(matcher.group("quantity")) * Double.parseDouble(matcher.group("price")));
                totalIncome += Integer.parseInt(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
