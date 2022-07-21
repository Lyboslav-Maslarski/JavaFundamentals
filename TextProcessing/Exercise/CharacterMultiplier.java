package TextProcessing.Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int longerStringSize = Math.max(str1.length(),str2.length());
        int shorterStringSize = Math.min(str1.length(),str2.length());
        String longerString = null;
        if (str1.length() > str2.length()) {
            longerString = str1;
        } else {
            longerString = str2;
        }
        int sum = 0;
        for (int i = 0; i < longerStringSize; i++) {
            if (i < shorterStringSize) {
                sum += str1.charAt(i) * str2.charAt(i);
            } else {
                sum += longerString.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
