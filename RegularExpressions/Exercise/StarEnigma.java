package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        Pattern pattern = Pattern.compile("@(?<name>[A-z]+)[^@:!\\->]*:\\d+[^@:!\\->]*!(?<result>[AD])![^@:!\\->]*->\\d+");
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            int decryptKey = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.toLowerCase().charAt(j) == 's' || input.toLowerCase().charAt(j) == 't'
                        || input.toLowerCase().charAt(j) == 'a' || input.toLowerCase().charAt(j) == 'r') {
                    decryptKey++;
                }
            }
            StringBuilder massage = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                char toAdd = input.charAt(j);
                toAdd -= decryptKey;
                massage.append(toAdd);
            }
            Matcher matcher = pattern.matcher(massage);
            if (matcher.find()) {
                String planetName = matcher.group("name");
                String result = matcher.group("result");
                if (result.equals("A")) {
                    attackedPlanets.add(planetName);
                } else {
                    destroyedPlanets.add(planetName);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        if (attackedPlanets.size() > 0) {
            attackedPlanets.stream().sorted().forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (destroyedPlanets.size() > 0) {
            destroyedPlanets.stream().sorted().forEach(p -> System.out.println("-> " + p));
        }
    }
}
