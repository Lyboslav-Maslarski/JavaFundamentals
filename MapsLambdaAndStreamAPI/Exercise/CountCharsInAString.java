package MapsLambdaAndStreamAPI.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        Map<Character, Integer> charOccurrence = new LinkedHashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (charOccurrence.get(word.charAt(i)) == null) {
                    charOccurrence.put(word.charAt(i), 1);
                } else {
                    int occurrence = charOccurrence.get(word.charAt(i));
                    charOccurrence.put(word.charAt(i), occurrence + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : charOccurrence.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
