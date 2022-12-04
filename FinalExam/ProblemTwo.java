package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#");
        Matcher matcher;
        while (n-- > 0) {
            String input = scan.nextLine();
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String title = matcher.group("title");
                System.out.println(name + ", The " + title);
                System.out.println(">> Strength: " + name.length());
                System.out.println(">> Armor: " + title.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
