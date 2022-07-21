package MapsLambdaAndStreamAPI.Lab;

import java.util.*;


public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> wordOccurrence = new LinkedHashMap<>();
        for (String word : words) {
            Integer currentCount = wordOccurrence.get(word);
            if (wordOccurrence.get(word) == null) {
                wordOccurrence.put(word, 1);
            } else {
                wordOccurrence.put(word, currentCount + 1);
            }
        }

        List<String> oddOccurrenceWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordOccurrence.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurrenceWords.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddOccurrenceWords.size(); i++) {
            String word = oddOccurrenceWords.get(i);
            if (i == oddOccurrenceWords.size() - 1) {
                System.out.printf("%s", word);
            } else {
                System.out.printf("%s, ", word);
            }
        }
    }
}
