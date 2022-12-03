package FinalExamPreparation.FinalExam04April2020;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+");
        Matcher matcher;

        while (n-- > 0) {
            String barcode = scan.nextLine();
            matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String productGroup = findProductGroup(matcher.group());
                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static String findProductGroup(String barcode) {
        StringBuilder productGroup = new StringBuilder();
        for (char c : barcode.toCharArray()) {
            if (Character.isDigit(c)) {
                productGroup.append(c);
            }
        }
        return productGroup.length() == 0 ? "00" : productGroup.toString();
    }
}
