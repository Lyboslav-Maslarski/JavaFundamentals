package TextProcessing.Exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scan.nextLine());
        int explosionStrength = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (explosionStrength > 0 && sb.charAt(i) != '>') {
                sb.deleteCharAt(i);
                explosionStrength--;
                i--;
            } else if (sb.charAt(i) == '>') {
                explosionStrength += Integer.parseInt(String.valueOf(sb.charAt(i + 1)));
            }
        }
        System.out.println(sb);
    }
}
