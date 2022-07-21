package TextProcessing.MoreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            System.out.println(input.substring(input.indexOf('@') + 1, input.indexOf('|')) + " is " + input.substring(input.indexOf('#') + 1, input.indexOf('*')) + " years old.");
        }
    }
}
