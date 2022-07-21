package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String lina = scan.nextLine();
        Pattern pattern = Pattern.compile("(?<=\\s)[A-Za-z\\d]+[\\w.-]*@[A-Za-z.-]+?[A-Za-z.\\-_]*\\.[a-z]{2,}");
        Matcher matcher = pattern.matcher(lina);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
