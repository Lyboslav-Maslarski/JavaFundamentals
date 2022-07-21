package MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> wordWithSynonyms = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            if (wordWithSynonyms.get(word) == null) {
                wordWithSynonyms.put(word, new ArrayList<>());
            }
            wordWithSynonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordWithSynonyms.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            List<String> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                String s = value.get(i);
                if (i == value.size() - 1) {
                    System.out.printf("%s", s);
                } else {
                    System.out.printf("%s, ", s);
                }
            }
            System.out.println();
        }
    }
}
