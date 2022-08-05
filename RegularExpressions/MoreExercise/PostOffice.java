package RegularExpressions.MoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        Pattern pattern = Pattern.compile("([#$%*&])(?<chars>[A-Z]+)\\1");
        Matcher matcher = pattern.matcher(input[0]);
        char[] startingChars = new char[]{};
        if (matcher.find()) {
            startingChars = matcher.group("chars").toCharArray();
        }
        Map<Character, Integer> startingCharWithLength = new HashMap<>();
        pattern = Pattern.compile("(\\d{2}):(\\d{2})");
        matcher = pattern.matcher(input[1]);
        while (matcher.find()) {
            int charToAdd = Integer.parseInt(matcher.group(1));
            char toAdd = (char) charToAdd;
            int length = Integer.parseInt(matcher.group(2));
            startingCharWithLength.put(toAdd, length);
        }
        for (char search : startingChars) {
            pattern = Pattern.compile(String.format("(^| )%c.{%d}( |$)", search, startingCharWithLength.get(search)));
            matcher = pattern.matcher(input[2]);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
