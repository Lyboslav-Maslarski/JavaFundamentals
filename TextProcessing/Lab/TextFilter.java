package TextProcessing.Lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWord = scan.nextLine().split(", ");
        String text = scan.nextLine();
        for (String ban : bannedWord) {
            while (text.contains(ban)) {
                text = text.replace(ban, "*".repeat(ban.length()));
            }
        }
        System.out.println(text);
    }
}
