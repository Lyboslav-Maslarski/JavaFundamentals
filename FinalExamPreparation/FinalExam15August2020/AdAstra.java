package FinalExamPreparation.FinalExam15August2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    static class Product {
        String name;
        String data;
        int calories;

        public Product(String name, String data, int calories) {
            this.name = name;
            this.data = data;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> productList = new ArrayList<>();
        int totalCalories = 0;
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([#|])(?<product>[A-Z a-z]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int calories = Integer.parseInt(matcher.group("calories"));
            totalCalories += calories;
            productList.add(String.format("Item: %s, Best before: %s, Nutrition: %d", matcher.group("product"), matcher.group("date"), calories));

        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        productList.forEach(System.out::println);
    }
}
