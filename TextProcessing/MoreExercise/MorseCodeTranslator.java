package TextProcessing.MoreExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> morseCode = new TreeMap<>();
        morseCode.put(".-", "A");
        morseCode.put("-...", "B");
        morseCode.put("-.-.", "C");
        morseCode.put("-..", "D");
        morseCode.put(".", "E");
        morseCode.put("..-.", "F");
        morseCode.put("--.", "G");
        morseCode.put("....", "H");
        morseCode.put("..", "I");
        morseCode.put(".---", "J");
        morseCode.put("-.-", "K");
        morseCode.put(".-..", "L");
        morseCode.put("--", "M");
        morseCode.put("-.", "N");
        morseCode.put("---", "O");
        morseCode.put(".--.", "P");
        morseCode.put("--.-", "Q");
        morseCode.put(".-.", "R");
        morseCode.put("...", "S");
        morseCode.put("-", "T");
        morseCode.put("..-", "U");
        morseCode.put("...-", "V");
        morseCode.put(".--", "W");
        morseCode.put("-..-", "X");
        morseCode.put("-.--", "Y");
        morseCode.put("--..", "Z");
        StringBuilder massage = new StringBuilder();
        String[] morseMassage = scan.nextLine().split("\\s+");
        for (String s : morseMassage) {
            if (s.equals("|")) {
                massage.append(" ");
            } else {
                massage.append(morseCode.get(s));
            }
        }
        System.out.println(massage);
    }
}
