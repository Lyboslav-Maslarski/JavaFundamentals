package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] demons = scan.nextLine().split("[,\\s]+");
        Pattern patternForHealth = Pattern.compile("[^\\d.+\\-*/]");
        Pattern patternForDamage = Pattern.compile("-?[\\d.]+");
        Pattern patternForDamage2 = Pattern.compile("[*/]");
        for (int i = 0; i < demons.length; i++) {
            Matcher matcherForHealth = patternForHealth.matcher(demons[i]);
            int health = 0;
            while (matcherForHealth.find()) {
                health += matcherForHealth.group().charAt(0);
            }
            Matcher matcherForDamage = patternForDamage.matcher(demons[i]);
            double damage = 0;
            while (matcherForDamage.find()) {
                damage += Double.parseDouble(matcherForDamage.group());
            }
            Matcher matcherForDamage2 = patternForDamage2.matcher(demons[i]);
            while (matcherForDamage2.find()) {
                if (matcherForDamage2.group().equals("*")) {
                    damage *= 2;
                } else {
                    damage /= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demons[i], health, damage);
        }
    }
}
