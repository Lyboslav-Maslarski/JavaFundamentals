package RegularExpressions.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!G!");
        String input = scan.nextLine();
        while (!input.equals("end")) {
            StringBuilder decryptedMassage = new StringBuilder(input.length());
            for (int i = 0; i < input.length(); i++) {
                char newChar = input.charAt(i);
                newChar -= key;
                decryptedMassage.append(newChar);
            }
            Matcher matcher = pattern.matcher(decryptedMassage);
            if (matcher.find()) {
                System.out.println(matcher.group("name"));
            }
            input = scan.nextLine();
        }
    }
}
