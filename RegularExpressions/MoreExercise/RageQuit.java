package RegularExpressions.MoreExercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toUpperCase();
        StringBuilder rageMassage = new StringBuilder(input.length());
        Pattern pattern = Pattern.compile("(?<text>\\D+)(?<repetitions>\\d+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String text = matcher.group("text");
            int repetitions = Integer.parseInt(matcher.group("repetitions"));
            for (int i = 0; i < repetitions; i++) {
                rageMassage.append(text);
            }
        }
        Set<Character> uniqueSymbols = new HashSet<>();
        for (int i = 0; i < rageMassage.length(); i++) {
            char toAdd = rageMassage.charAt(i);
            uniqueSymbols.add(toAdd);
        }
        System.out.printf("Unique symbols used: %d%n", uniqueSymbols.size());
        System.out.println(rageMassage);
    }
}
