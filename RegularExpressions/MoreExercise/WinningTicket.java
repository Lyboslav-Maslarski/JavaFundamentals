package RegularExpressions.MoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split("[, ]+");
        Pattern pattern = Pattern.compile("(@{6,9}|\\^{6,9}|#{6,9}|\\${6,9})");
        for (int i = 0; i < tickets.length; i++) {
            String currentTicket = tickets[i];
            if (currentTicket.length() != 20) {
                System.out.println("invalid ticket");
            } else if (currentTicket.matches("@{20}|\\^{20}|#{20}|\\${20}")) {
                System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", currentTicket, currentTicket.charAt(0));
            } else {
                Matcher matcher1 = pattern.matcher(currentTicket.substring(0, 10));
                Matcher matcher2 = pattern.matcher(currentTicket.substring(10));
                if (matcher1.find() && matcher2.find() && matcher1.group().charAt(0) == matcher2.group().charAt(0)) {
                    System.out.printf("ticket \"%s\" - %d%c%n", currentTicket, Math.min(matcher1.group().length(), matcher2.group().length()), matcher1.group().charAt(0));
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", currentTicket);
                }
            }

        }
    }
}
