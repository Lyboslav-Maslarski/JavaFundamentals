package DataTypesAndVariables.MoreExercise;

import javax.swing.text.StringContent;
import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String dataType = "";
                if (input.matches("\\d+") || input.matches("-\\d+")) {
                    dataType = "integer";
                } else if (input.matches("\\d*[.]\\d+") || input.matches("-\\d*[.]\\d+")) {
                    dataType = "floating point";
                } else if (input.length() == 1) {
                    dataType = "character";
                } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                    dataType = "boolean";
                } else {
                    dataType = "string";
                }
            System.out.printf("%s is %s type%n", input, dataType);
            input = scan.nextLine();
        }
    }
}
