package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile(">>(?<product>[A-z]+)<<(?<price>[\\d.]+)!(?<quantity>\\d+)");
        List<String> products = new ArrayList<>();
        double sum = 0;
        String input = scan.nextLine();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                products.add(matcher.group("product"));
                sum += Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        products.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }
}
