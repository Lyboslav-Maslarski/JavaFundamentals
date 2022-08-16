package FinalExamPreparation.FinalExam10April2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<word1>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        int matchCounter = 0;
        List<String> mirroredWords = new ArrayList<>();
        while (matcher.find()) {
            matchCounter++;
            String word1 = matcher.group("word1");
            String word2 = matcher.group("word2");
            StringBuilder reversedWord2 = new StringBuilder(word2).reverse();
            if (word1.equals(reversedWord2.toString())) {
                mirroredWords.add(word1 + " <=> " + word2);
            }
        }
        if (matchCounter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(matchCounter + " word pairs found!");
        }
        if (mirroredWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirroredWords));
        }
    }
}
