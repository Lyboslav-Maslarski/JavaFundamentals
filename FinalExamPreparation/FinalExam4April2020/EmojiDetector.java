package FinalExamPreparation.FinalExam4April2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        long coolness = 1;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            coolness *= Integer.parseInt(matcher.group());
        }
        List<String> emojis = new ArrayList<>();
        pattern = Pattern.compile("(::|\\*\\*)[A-Z][a-z]{2,}\\1");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            emojis.add(matcher.group());
        }
        System.out.println("Cool threshold: " + coolness);
        System.out.println(emojis.size() + " emojis found in the text. The cool ones are:");

        for (String emoji : emojis) {
            long currentCoolness = 0;
            for (int i = 2; i < emoji.length() - 2; i++) {
                currentCoolness += emoji.charAt(i);
            }
            if (currentCoolness >= coolness) {
                System.out.println(emoji);
            }
        }
    }
}
